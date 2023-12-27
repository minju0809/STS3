package com.springbook.biz.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PsdDaoImpl implements PsdDao {

	@Autowired
	
	@Override
	public List<PsdVO> getPsdList() {
		return null;
	}

	@Override
	public void insert(PsdVO vo) {
		
	}

}
