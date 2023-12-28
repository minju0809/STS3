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

	@Override
	public void delete(PsdVO vo) {
		mybatis.delete("PsdDao.delete_sql", vo);
	}

	@Override
	public PsdVO getPsd(PsdVO vo) {
		return mybatis.selectOne("PsdDao.select1_sql", vo);
	}

	@Override
	public void cnt(PsdVO vo) {
		mybatis.update("PsdDao.cnt_sql", vo);
	}

	@Override
	public void update(PsdVO vo) {
		mybatis.update("PsdDao.update_sql", vo);
	}	

}
