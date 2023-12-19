package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("userService")
public class UserServiceImpl implements UserService {

//	@Autowired
//	private UserDao dao;

	private UserDao dao = null;

	public UserServiceImpl(UserDao dao) {
		dao = new UserDaoImpl();
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
