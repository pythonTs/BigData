select * from user_constraints;
select * from tab;
----------------------------------------------------------------
--------------�б� ���� ���������̺� �����---------------------
create table stuinfo(
snum char(10) constraint stuinfo_pk primary key,
sname varchar2(12) not null,
sex char(3) check (sex in ('��','��'))
);
select * from stuinfo;

create table subject(
    subjectcode char(10) primary key,
    subjectname char(30) not null );

create table takeclass(
    snum char(10) references stuinfo(snum),
    subjectcode char(10) references subject(subjectcode),
    grade int,
    applydate date default sysdate,
    constraint takeclass_pk primary key(snum,subjectcode)
);
--alter table takeclass alter column applydate date;
drop table takeclass;
select * from takeclass;
----------�������Է�----------
insert into stuinfo values('52121813','KIMSANGJUN','��');
insert into stuinfo values('52121892','JOOHYUNGU','��');
insert into stuinfo values('52121802','KANGBUMSIN','��');
insert into stuinfo values('52121824','KANGSINWOO','��');
insert into stuinfo values('42521813','KIMSOYUN','��');

insert into subject values('1021','MATH2');
insert into subject values('1022','MATH3');
insert into subject values('1023','CHINA');
insert into subject values('2201','COMPUTER');
insert into subject values('2221','JAVASTUDY');

insert into takeclass values('52121813','1021',95,default);
insert into takeclass values('52121892','1021',80,default);
insert into takeclass values('52121802','2201',75,default);
insert into takeclass values('52121824','2221',95,default);
insert into takeclass values('42521813','1022',100,default);

select * from stuinfo inner join takeclass
on stuinfo.snum = takeclass.snum; 