

-- create user
-- CREATE USER 'neauser'@'%' IDENTIFIED BY 'neapassword';
-- GRANT ALL PRIVILEGES ON nea.* TO 'neauser'@'%' WITH GRANT OPTION;
-- FLUSH PRIVILEGES;

-- create schema

create database nea;
use nea;

CREATE TABLE Teacher(
teacherID int PRIMARY KEY NOT NULL auto_increment,
firstName varchar(100),
lastName varchar(100),
email varchar(100),
department varchar(100),
password varchar(100)
);

CREATE TABLE ExamPaper(
examPaperID int PRIMARY KEY NOT NULL auto_increment,
yearGroup int,
typeOfExam varchar(20),
paperNumber varchar(20),
subject varchar(10),
duration varchar(50),
instructions varchar(100),
materials varchar(100),
totalMark int,
status varchar(50),
teacherID int,
FOREIGN KEY (TeacherID) 
REFERENCES Teacher(TeacherID)
ON DELETE CASCADE
);

CREATE TABLE ExamQuestion(
    questionID int PRIMARY KEY NOT NULL AUTO_INCREMENT, 
    questionNumber varchar(10),
    examPaperID int,
    FOREIGN KEY (examPaperID) 
    REFERENCES ExamPaper(examPaperID)
    ON DELETE CASCADE,
    content LONGBLOB,
    marks int,
    amountOfLines int,
    INDEX idx_questionNumber (questionNumber)  -- Add this line to create an index
);

CREATE TABLE SubQuestion(
subQuestionID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
subQuestionNumber varchar(10),
questionID int,
FOREIGN KEY (questionID) 
REFERENCES ExamQuestion(questionID)
ON DELETE CASCADE,
content LONGBLOB,
marks int,
amountOfLines int
);



CREATE TABLE Student(
studentID int PRIMARY KEY NOT NULL,
fName varchar(50),
lname varchar(50)
);



CREATE TABLE Marks(
marksID int PRIMARY KEY NOT NULL AUTO_INCREMENT,
examPaperID int, 
FOREIGN KEY (examPaperID) 
REFERENCES ExamPaper(examPaperID)
ON DELETE CASCADE,
studentID int, 
FOREIGN KEY (studentID)
 REFERENCES Student(studentID)
 ON DELETE CASCADE,
questionID int,
FOREIGN KEY (questionID)
 REFERENCES ExamQuestion(questionID)
 ON DELETE CASCADE,
teacherID int, 
FOREIGN KEY (teacherID)
 REFERENCES Teacher(teacherID)
 ON DELETE CASCADE,
subQuestionID int,
FOREIGN KEY (subQuestionID) 
REFERENCES SubQuestion(subQuestionID)
ON DELETE CASCADE,
marksObtained int,
totalMarks int
);


-- end
ALTER SCHEMA `nea`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;


show tables;

