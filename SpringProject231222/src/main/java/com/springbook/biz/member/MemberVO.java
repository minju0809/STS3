package com.springbook.biz.member;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberVO {
	private String memberId;
	private String name;
	private String pwd;
	private String phone;
	private String address;
	private String grade;
	private String etc;
	
	private String ch1;
	private String ch2;
}
