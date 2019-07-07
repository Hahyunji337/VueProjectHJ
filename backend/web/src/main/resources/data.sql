DROP TABLE IF EXISTS members;
create table members (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name varchar(50) not null,
	email varchar(50) UNIQUE,
	password varchar(50)  not null,
	grade varchar(1) not null,
	introduce varchar(1000)
)DEFAULT CHARSET=utf8;
-- create sequence members_seq start with 1 increment by 1;
-- insert into members(name, email, password, grade, introduce) values ('전정국','1234@gmail.com','1234','1','안녕하세요 저는 방탄소년단 황금막내 전정국입니다.');
-- insert into members(name, email, password, grade, introduce) values ('남도현','1@gmail.com','1234','2','');
-- insert into members(name, email, password, grade, introduce) values ('안유진','h@gmail.com','1234','3','강아지 좋아합니다.');
-- insert into members(name, email, password, grade, introduce) values ('강민희','haha@gmail.com','1234','3','잘부탁드려요');
-- insert into members(name, email, password, grade, introduce) values ('김태형','ha@gmail.com','1234','3','잘부탁드려요~~~');
-- insert into members(name, email, password, grade, introduce) values ('배진영','2@gmail.com','1234','3','ㅎㅎ');
-- insert into members(name, email, password, grade, introduce) values ('라이관린','3@gmail.com','1234','3','하하하');
commit;