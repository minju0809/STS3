package com.jungbo.biz.campsite;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CampsiteDaoImpl implements CampsiteDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<CampsiteVO> getCampsiteList(CampsiteVO vo) {
		return mybatis.selectList("CampsiteDao.select_sql", vo);
	}

	@Override
	public CampsiteVO getCampsiteOne(CampsiteVO vo) {
		return mybatis.selectOne("CampsiteDao.selectOne_sql", vo);
	}

}
