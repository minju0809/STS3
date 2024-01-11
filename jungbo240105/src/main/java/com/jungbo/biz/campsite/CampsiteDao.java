package com.jungbo.biz.campsite;

import java.util.List;

public interface CampsiteDao {
	List<CampsiteVO> getCampsiteList(CampsiteVO vo);
	CampsiteVO getCampsiteOne(CampsiteVO vo);
}
