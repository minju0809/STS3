package com.springbook.biz.psd;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<PsdVO> getPsdList() {
		return mybatis.selectList("PsdDao.select_sql");
	}

	@Override
	public void insert(PsdVO vo) {
		mybatis.insert("PsdDao.insert_sql", vo);
	}

}
