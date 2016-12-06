drop table student;
create table student(
id number(5),
name varchar2(32),
age number(3)
);

--创建序列
create sequence student_seq
increment by 1    -- 每次递增1
start with 1       -- 从1开始
nomaxvalue      -- 没有最大值
minvalue 1;       -- 最小值=1

-- 创建触发器
create or replace trigger tri_student
before insert
on student
for each row
begin
  select student_seq.nextval into :new.id from dual;
end;

insert into student values(null, 'zhangsan', '19');