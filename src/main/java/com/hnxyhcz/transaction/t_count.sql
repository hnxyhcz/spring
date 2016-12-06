drop table t_count;
create table t_count(
id number,
userId number,
username varchar2(32),
count number
);

insert into t_count values(1, 1, 'zhangsan', 500);
insert into t_count values(2, 2, 'zhangsan', 500);