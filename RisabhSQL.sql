create database mentorselector;
use mentorselector;

create table mentors(mentorid int NOT NULL,
mentorname varchar(100) NOT NULL, 
specialisation varchar(50) NOT NULL,
areaofstudy varchar(50) NOT NULL,
experience int NOT NULL,
PRIMARY KEY(mentorid));

insert into mentors values (1, "Name 1", "Artificial Intelligence", "Geoinformatics", 5);
insert into mentors values (2, "Name 2", "Artificial Intelligence", "Machine Learning", 3);
insert into mentors values (3, "Name 3", "Artificial Intelligence", "Healthcare with AI", 10);
insert into mentors values (4, "Name 4", "Big Data", "Hadoop", 7);
insert into mentors values (5, "Name 5", "Big Data", "Data Science", 6);
insert into mentors values (6, "Name 6", "Big Data", "Data Analytics", 7);
insert into mentors values (7, "Name 7", "CCVT", "Cloud Computing", 9);
insert into mentors values (8, "Name 8", "CCVT", "AWS", 5);
insert into mentors values (9, "Name 9", "CCVT", "Azure", 1);
insert into mentors values (10, "Name 10", "IOT", "Robotics", 6);
insert into mentors values (11, "Name 11", "IOT", "Arduino", 4);
insert into mentors values (12, "Name 12", "IOT", "Smart Cities", 6);
insert into mentors values (13, "Name 13", "Cyber Security", "Ethical Hacking", 5);
insert into mentors values (14, "Name 14", "Cyber Security", "Network Security", 8);
insert into mentors values (15, "Name 15", "Cyber Security", "Ransomware", 11);
insert into mentors values (16, "Name 16", "CCVT", "AWS", 11);
insert into mentors values (17, "Name 17", "IOT", "Arduino", 6, 0, "a");

ALTER TABLE mentors RENAME COLUMN specialisation TO specialization;
ALTER TABLE mentors RENAME COLUMN areaofstudy TO area_of_study;
ALTER TABLE mentors ADD contactno int NOT NULL;
ALTER TABLE mentors ADD emailid varchar(255) NOT NULL;

select * from mentors;