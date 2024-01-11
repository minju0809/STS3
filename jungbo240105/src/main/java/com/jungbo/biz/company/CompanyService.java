package com.jungbo.biz.company;

import java.util.List;

public interface CompanyService {
	void companyInsert(CompanyVO vo);
	List<CompanyVO> getCompanyList(CompanyVO vo);
}
