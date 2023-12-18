package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return dao.getUser(vo);
	}

}
