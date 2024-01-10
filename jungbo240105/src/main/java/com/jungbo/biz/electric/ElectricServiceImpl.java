package com.jungbo.biz.electric;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricServiceImpl implements ElectricService {
	
	@Autowired
	private ElectricDao dao;

	@Override
	public List<ElectricVO> getElectricList(ElectricVO vo) {
		return dao.getElectricList(vo);
	}

	@Override
	public ElectricVO getElectricOne(ElectricVO vo) {
		return dao.getElectricOne(vo);
	}

}
