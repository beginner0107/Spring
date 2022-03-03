-- member table 생성
create table member(
 num int primary key auto_increment,
 id varchar(20) not null,
 pass varchar(20) not null,
 name varchar(30) not null,
 age int not null,
 email varchar(30) not null,
 phone varchar(30) not null,
 unique key(id)
);

select * from member;

insert into member (id, pass, name, age, email, phone)
values('admin', 'admin', '관리자', 40, 'bit@naver.com', '010-1111-1111');

drop table member;

create table member1(
 num int primary key auto_increment,
 id varchar(20) not null,
 pass varchar(20) not null,
 name varchar(30) not null,
 age int not null,
 email varchar(30) not null,
 phone varchar(30) not null,
 filename varchar(100),
 unique key(id)
);
