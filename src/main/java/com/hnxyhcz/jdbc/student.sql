drop table student;
create table student(
id number(5),
name varchar2(32),
age number(3)
);

--��������
create sequence student_seq
increment by 1    -- ÿ�ε���1
start with 1       -- ��1��ʼ
nomaxvalue      -- û�����ֵ
minvalue 1;       -- ��Сֵ=1

-- ����������
create or replace trigger tri_student
before insert
on student
for each row
begin
  select student_seq.nextval into :new.id from dual;
end;

insert into student values(null, 'zhangsan', '19');