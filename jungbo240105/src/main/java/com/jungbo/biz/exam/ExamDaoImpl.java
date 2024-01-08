package com.jungbo.biz.exam;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoImpl implements ExamDao {
	
	@Autowired
	public SqlSessionTemplate mybatis; 
	
	@Override
	public List<ExamVO> getExamList(ExamVO vo) {
		return mybatis.selectList("ExamDao.select_sql", vo);
	}

	@Override
	public void ExamInsert(ExamVO vo) {
		mybatis.insert("ExamDao.insert_sql", vo);
	}

	@Override
	public int snoCk(ExamVO vo) {
		return mybatis.selectOne("ExamDao.selectSnoCk_sql", vo);
	}

	@Override
	public int snameCk(ExamVO vo) {
		return mybatis.selectOne("ExamDao.selectSnameCk_sql", vo);
	}
}
