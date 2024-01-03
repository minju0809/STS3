package com.springbook.biz.guestbook;

import java.util.List;

public interface GuestbookDao {
	List<GuestbookVO> getGuestbookList(GuestbookVO vo);
}
