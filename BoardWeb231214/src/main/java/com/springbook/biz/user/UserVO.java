package com.springbook.biz.user;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
}
