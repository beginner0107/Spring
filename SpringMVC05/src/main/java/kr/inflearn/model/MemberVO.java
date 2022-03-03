package kr.inflearn.model;

import lombok.Data;

@Data
public class MemberVO {
	private int num;
	private String id;
	private String pass;
	private String name;
	private int age;
	private String email;
	private String phone;
	private String filename;
}
