package com.hnxyhcz.test;

import java.util.concurrent.Phaser;

public class PhaserSamples1 {
	
	public static void main(String[] args) throws InterruptedException {
		new PhaserSamples1().runTasks();
		System.exit(0);
	}
	
    // 一共开几场会
    private static final int PHASE_TO_TERMINATE = 2;
    // 初始参会人员数量
    private static final int INIT_PARTIES = 1;
    // 增加参会人员数量
    private static final int ADD_PARTIES = 5;
    // 每个会场限制参会者数量
    private static final int TASKS_PER_PHASER = 10;
    
    void runTasks() throws InterruptedException {
    	
        final Phaser phaser = new Phaser(INIT_PARTIES) {
        	// 所有人员到达完毕，开始会议；连续开PHASE_TO_TERMINATE - 1 场会议，会议结束（terminal）
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("第" + (phase + 1) + "场会议结束");
                return phase == (PHASE_TO_TERMINATE - 1) || registeredParties == 0;
            }
        };
        
        final Task tasks[] = new Task[ADD_PARTIES];
        System.out.println("会议开始准备,需要至少" + INIT_PARTIES + "人签到, 共连续" + PHASE_TO_TERMINATE + "场会议,分会场数量" +
                (ADD_PARTIES % TASKS_PER_PHASER == 0 ? (ADD_PARTIES / TASKS_PER_PHASER) : (ADD_PARTIES / TASKS_PER_PHASER + 1)));
        System.out.println("Main准备参加第一场会议,开始签到,共" + phaser.getRegisteredParties() + "人签到");
        build(tasks, 0, tasks.length, phaser);
        for (int i = 0; i < tasks.length; i++) {
            final Thread thread = new Thread(tasks[i]);
            thread.start();
        }
        phaser.arriveAndDeregister();
        System.out.println("Main离开会场");
//	        phaser.arriveAndAwaitAdvance();
//	        System.out.println("Main休息准备下一场会议");
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
            System.out.println("参会人员" + id + "已经签到,共" + phaser.getRegisteredParties() + "人签到");
        }
        
        @Override
        public void run() {
        	// 参加每一场会议
            while (!phaser.isTerminated()) {
                try {
                	// 签到之后，走到会场
                    Thread.sleep(20 * id + 20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("参会人员" + this.id + "已经到达第" + (phaser.getPhase() + 1) + "场会议, 当前共有"
                        + phaser.getRegisteredParties() + " 人参会,"
                        + (phaser.getArrivedParties() + 1) + " 到达,"
                        + (phaser.getUnarrivedParties() - 1) + " 未到达");
                // 到达会场
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
