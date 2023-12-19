package com.springbook.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoSpring implements UserDao {

	@Autowired
	private JdbcTemplate tdbmTemplate;

	String select_sql = "select * from users where id=? and password=?";

	@Override
	public UserVO getUser(UserVO vo) {
		Object[] args = { vo.getId(), vo.getPassword() };
		return tdbmTemplate.queryForObject(select_sql, new UserRowMapper(), args);
	}

}
