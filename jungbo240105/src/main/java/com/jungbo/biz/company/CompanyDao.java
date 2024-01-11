package com.jungbo.biz.company;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {
	void companyInsert(CompanyVO vo);
	List<CompanyVO> getCompanyList(CompanyVO vo);
}
