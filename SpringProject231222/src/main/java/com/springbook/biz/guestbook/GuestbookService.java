package com.springbook.biz.guestbook;

import java.util.List;

public interface GuestbookService {
	List<GuestbookVO> getGuestbookList(GuestbookVO vo);
	int getTotalCount(GuestbookVO vo);
	
	void guestbookInsert(GuestbookVO vo);
	void guestbookDelete(GuestbookVO vo);
}
