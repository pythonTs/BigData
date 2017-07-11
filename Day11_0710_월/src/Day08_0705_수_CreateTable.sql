create table student (
sNum char(10) constraint student_sNum_PK primary key ,
sName Varchar2(10) not null,
gender Char(2) not null check(gender in ('³²','¿©')));

-------------------------------------------------------------------------------
create table subject (
subjectCode char(10) constraint subject_subjectCode_PK primary key,
subjectName varchar2(30) not null);

-------------------------------------------------------------------------------
create table lecture(
sNum char(10) constraint lecture_sNum_FK references student(sNum) on delete cascade,
subjectCode char(10) constraint lecture_subjectCode_FK references subject(subjectCode) on delete cascade,
score number(5,2),
grade char(4),
joinData date default sysdate,
constraint lecture_PK primary key(sNum,subjectCode));

-------------------------------------------------------------------------------