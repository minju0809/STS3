package com.springbook.biz.psd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PsdServiceImpl implements PsdService {

	@Autowired
	private PsdDao dao;
	
	@Override
	public List<PsdVO> getPsdList() {
		return dao.getPsdList();
	}

	@Override
	public void insert(PsdVO vo) {
		dao.insert(vo);
	}

	@Override
	public void delete(PsdVO vo) {
		dao.delete(vo);
	}

	@Override
	public PsdVO getPsd(PsdVO vo) {
		return dao.getPsd(vo);
	}

}
