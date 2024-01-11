package com.jungbo.biz.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyDao dao;
	
	@Override
	public void companyInsert(CompanyVO vo) {
		dao.companyInsert(vo);
	}

	@Override
	public List<CompanyVO> getCompanyList(CompanyVO vo) {
		return dao.getCompanyList(vo);
	}

}
