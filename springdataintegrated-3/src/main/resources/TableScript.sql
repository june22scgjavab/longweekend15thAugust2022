drop database if exists assessment_db;

create database assessment_db;

use assessment_db;

create table assessment(
assessment_id int,
assessment_name VARCHAR(20),
max_marks int,
passing_marks int,
constraint pk_assessment_id primary key(assessment_id)
);

create table student (
    student_id int auto_increment,
    student_name varchar(20),
    date_of_birth date,
    marks_scored int,
    assessment_id int,
    constraint pk_student_id primary key (student_id),
    
    constraint fk_assessment_id foreign key (assessment_id) references assessment(assessment_id)
);

INSERT INTO assessment VALUES(111,'Java',100,60);
INSERT INTO assessment VALUES(222,'DOTNET',100,60);
INSERT INTO assessment VALUES(333,'HTML',100,50);
INSERT INTO assessment VALUES(444,'MAINFRAME',100,40);


INSERT INTO student(student_name,date_of_birth,marks_scored,assessment_id) VALUES('Paul','1998-10-23',60,111);
INSERT INTO student(student_name,date_of_birth,marks_scored,assessment_id) VALUES('John','2000-11-13',70,222);
INSERT INTO student(student_name,date_of_birth,marks_scored,assessment_id) VALUES('Joseph','2001-06-16',80,111);
INSERT INTO student(student_name,date_of_birth,marks_scored,assessment_id) VALUES('Joana','2006-12-05',90,333);




commit;

select * from assessment;
select * from student;
