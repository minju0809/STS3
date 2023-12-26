package com.springbook.biz.exam;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoImpl implements ExamDao {

	@Autowired
	public SqlSessionTemplate mybatis;
	
	@Override
	public List<ExamVO> getBoardList(ExamVO vo) {
		System.out.println("@@@@@@@@@@@ch1: " + vo.getCh1() + ", ch2: " + vo.getCh2());
		return mybatis.selectList("ExamDao.select_sql", vo);
	}

}
