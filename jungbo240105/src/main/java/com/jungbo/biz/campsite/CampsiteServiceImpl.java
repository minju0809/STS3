package com.jungbo.biz.campsite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampsiteServiceImpl implements CampsiteService {

	@Autowired
	private CampsiteDao dao;
	
	@Override
	public List<CampsiteVO> getCampsiteList(CampsiteVO vo) {
		return dao.getCampsiteList(vo);
	}

	@Override
	public CampsiteVO getCampsiteOne(CampsiteVO vo) {
		return dao.getCampsiteOne(vo);
	}

}
