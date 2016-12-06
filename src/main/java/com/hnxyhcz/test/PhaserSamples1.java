package com.hnxyhcz.test;

import java.util.concurrent.Phaser;

public class PhaserSamples1 {
	
	public static void main(String[] args) throws InterruptedException {
		new PhaserSamples1().runTasks();
		System.exit(0);
	}
	
    // һ����������
    private static final int PHASE_TO_TERMINATE = 2;
    // ��ʼ�λ���Ա����
    private static final int INIT_PARTIES = 1;
    // ���Ӳλ���Ա����
    private static final int ADD_PARTIES = 5;
    // ÿ���᳡���Ʋλ�������
    private static final int TASKS_PER_PHASER = 10;
    
    void runTasks() throws InterruptedException {
    	
        final Phaser phaser = new Phaser(INIT_PARTIES) {
        	// ������Ա������ϣ���ʼ���飻������PHASE_TO_TERMINATE - 1 �����飬���������terminal��
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("��" + (phase + 1) + "���������");
                return phase == (PHASE_TO_TERMINATE - 1) || registeredParties == 0;
            }
        };
        
        final Task tasks[] = new Task[ADD_PARTIES];
        System.out.println("���鿪ʼ׼��,��Ҫ����" + INIT_PARTIES + "��ǩ��, ������" + PHASE_TO_TERMINATE + "������,�ֻ᳡����" +
                (ADD_PARTIES % TASKS_PER_PHASER == 0 ? (ADD_PARTIES / TASKS_PER_PHASER) : (ADD_PARTIES / TASKS_PER_PHASER + 1)));
        System.out.println("Main׼���μӵ�һ������,��ʼǩ��,��" + phaser.getRegisteredParties() + "��ǩ��");
        build(tasks, 0, tasks.length, phaser);
        for (int i = 0; i < tasks.length; i++) {
            final Thread thread = new Thread(tasks[i]);
            thread.start();
        }
        phaser.arriveAndDeregister();
        System.out.println("Main�뿪�᳡");
//	        phaser.arriveAndAwaitAdvance();
//	        System.out.println("Main��Ϣ׼����һ������");
    }
    
    public static void build(Task[] tasks, int lo, int hi, Phaser ph) {
    	
        if (hi - lo > TASKS_PER_PHASER) {
            for (int i = lo; i < hi; i += TASKS_PER_PHASER) {
                int j = Math.min(i + TASKS_PER_PHASER, hi);
                build(tasks, i, j, new Phaser(ph));
            }
        } else {
            for (int i = lo; i < hi; ++i)
                tasks[i] = new Task(i + 1, ph);
        }
    }
    
    public static class Task implements Runnable {
        private final int id;
        private final Phaser phaser;
        
        public Task(int id, Phaser phaser) {
            this.id = id;
            this.phaser = phaser;
            this.phaser.register();
            System.out.println("�λ���Ա" + id + "�Ѿ�ǩ��,��" + phaser.getRegisteredParties() + "��ǩ��");
        }
        
        @Override
        public void run() {
        	// �μ�ÿһ������
            while (!phaser.isTerminated()) {
                try {
                	// ǩ��֮���ߵ��᳡
                    Thread.sleep(20 * id + 20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("�λ���Ա" + this.id + "�Ѿ������" + (phaser.getPhase() + 1) + "������, ��ǰ����"
                        + phaser.getRegisteredParties() + " �˲λ�,"
                        + (phaser.getArrivedParties() + 1) + " ����,"
                        + (phaser.getUnarrivedParties() - 1) + " δ����");
                // ����᳡
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
