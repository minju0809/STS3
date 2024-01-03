package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.guestbook.GuestbookService;
import com.springbook.biz.guestbook.GuestbookVO;


@Controller
@SessionAttributes("m")
public class GuestbookController {

	@Autowired
	private GuestbookService service;

	@RequestMapping(value = "guestbookList.do")
	public String guestbookList(Model model, GuestbookVO vo) {

		System.out.println("########################" + service.getGuestbookList(vo));
		model.addAttribute("li", service.getGuestbookList(vo));

		return "/guestbook/guestbookList.jsp";
	}
	
}
