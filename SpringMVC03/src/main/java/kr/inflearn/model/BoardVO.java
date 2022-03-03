package kr.inflearn.model;

import java.util.Date;

import lombok.Data;

/*
create table tb_board(
	idx int not null auto_increment, -- 자동증가(아이디)
	title varchar(100) not null, -- 제목
	contents varchar(4000) not null, -- 내용
	count int, -- 조회수
	writer varchar(30) not null, -- 작성자
	indate datetime default now() not null, -- 등록일
	primary key(idx)
);
 */
@Data
public class BoardVO {
	private int idx;
	private String title;
	private String contents;
	private int count;
	private String writer;
	private Date indate;
}
