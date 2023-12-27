package com.springbook.biz.psd;

import java.util.List;

public interface PsdService {
	List<PsdVO> getPsdList();
	void insert(PsdVO vo);
	void delete(PsdVO vo);
}
