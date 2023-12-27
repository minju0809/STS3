package com.springbook.biz.psd;

import java.util.List;

public interface PsdDao {
	List<PsdVO> getPsdList();
	void insert(PsdVO vo);
}
