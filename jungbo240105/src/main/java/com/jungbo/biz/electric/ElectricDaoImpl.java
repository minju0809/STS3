package com.jungbo.biz.electric;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ElectricDaoImpl implements ElectricDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<ElectricVO> getElectricList(ElectricVO vo) {
		return mybatis.selectList("ElectricDao.select_sql", vo);
	}

	@Override
	public ElectricVO getElectricOne(ElectricVO vo) {
		return mybatis.selectOne("ElectricDao.selectOne_sql", vo);
	}

	@Override
	public void insert(ElectricVO vo) {
		mybatis.insert("ElectricDao.insert_sql", vo);
	}

	@Override
	public List<ElectricVO> getMemoList(ElectricVO vo) {
		return mybatis.selectList("ElectricDao.selectMemo_sql", vo);
	}
	
}
