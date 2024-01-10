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
	
}
