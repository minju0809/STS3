package com.jungbo.biz.electric;

import java.util.List;

public interface ElectricService {
	List<ElectricVO> getElectricList(ElectricVO vo);
	ElectricVO getElectricOne(ElectricVO vo);
	
	List<ElectricVO> getMemoList(ElectricVO vo);
	void insert(ElectricVO vo);
}
