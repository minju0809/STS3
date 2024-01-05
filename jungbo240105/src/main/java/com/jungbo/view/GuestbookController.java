package com.jungbo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jungbo.biz.guestbook.GuestbookService;
import com.jungbo.biz.guestbook.GuestbookVO;

@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService service;
	
	@RequestMapping(value="index.do")
	public String index(GuestbookVO vo, Model model) {
		System.out.println("index.do 확인");
		
		return "index.jsp";
	}

	@RequestMapping(value = "/guestbookList.do", method=RequestMethod.GET)
	public String guestbookList(Model model, GuestbookVO vo) {
		
		model.addAttribute("li", service.getGuestbookList(vo));

		return "/guestbook/guestbookList.jsp";
	}
}
