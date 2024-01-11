package com.jungbo.biz.company;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDaoImpl implements CompanyDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public void companyInsert(CompanyVO vo) {
		System.out.println("###########################" + vo.getRdnmadr());
		mybatis.insert("CompanyDao.insert_sql", vo);
	}

	@Override
	public List<CompanyVO> getCompanyList(CompanyVO vo) {
		return mybatis.selectList("CompanyDao.select_sql", vo);
	}

}
