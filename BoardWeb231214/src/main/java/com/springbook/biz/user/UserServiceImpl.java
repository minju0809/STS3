package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl 객체 생성");
	}
	
	// Constructor 인젝션
//	public UserServiceImpl(UserDao dao) {
//		this.dao = dao;
//	}

	// Setter 인젝션
//	public void setDao(UserDao dao) {
//		this.dao = dao;
//	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
