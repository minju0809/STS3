package com.jungbo.biz.guestbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	
	@Autowired
	private GuestbookDao dao;

	@Override
	public List<GuestbookVO> getGuestbookList(GuestbookVO vo) {
		return dao.getGuestbookList(vo);
	}

}