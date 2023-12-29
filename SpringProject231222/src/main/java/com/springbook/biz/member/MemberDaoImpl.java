package com.springbook.biz.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<MemberVO> getMemberList(MemberVO vo) {
		return mybatis.selectList("MemberDao.select_sql", vo);
	}

	@Override
	public MemberVO getMember(MemberVO vo) {
		return mybatis.selectOne("MemberDao.select1_sql", vo);
	}
	
	@Override
	public int getMemberId() {
		return mybatis.selectOne("MemberDao.selectId_sql");
	}

	@Override
	public void insert(MemberVO vo) {
		mybatis.insert("MemberDao.insert_sql", vo);
	}

	@Override
	public void delete(MemberVO vo) {
		mybatis.insert("MemberDao.delete_sql", vo);
	}

	@Override
	public void update(MemberVO vo) {
		mybatis.insert("MemberDao.update_sql", vo);
	}
	
}
