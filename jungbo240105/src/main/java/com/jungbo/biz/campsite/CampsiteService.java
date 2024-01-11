package com.jungbo.biz.campsite;

import java.util.List;

public interface CampsiteService {
	List<CampsiteVO> getCampsiteList(CampsiteVO vo);
	CampsiteVO getCampsiteOne(CampsiteVO vo);
}
