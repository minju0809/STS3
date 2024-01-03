package com.springbook.biz.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestbookDaoImpl implements GuestbookDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<GuestbookVO> getGuestbookList(GuestbookVO vo) {
		return mybatis.selectList("GuestbookDao.select_sql", vo);
	}
}
