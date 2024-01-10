package com.jungbo.biz.electric;

import java.util.List;

public interface ElectricDao {
	List<ElectricVO> getElectricList(ElectricVO vo);
}
