package com.springbook.view;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.guestbook.GuestbookService;
import com.springbook.biz.guestbook.GuestbookVO;


@Controller
public class GuestbookController {

	@Autowired
	private GuestbookService service;

	@RequestMapping(value = "guestbookList.do", method=RequestMethod.GET)
	public String guestbookList(Model model, GuestbookVO vo) {
		
		model.addAttribute("totalCount", service.getTotalCount(vo));
		model.addAttribute("li", service.getGuestbookList(vo));

		return "/guestbook/guestbookList.jsp";
	}
	
	@RequestMapping(value = "guestbookInsert.do", method=RequestMethod.GET)
	public String guestbookInsert(GuestbookVO vo) {

		String name[] = {"하니","둘리","사샤","네모","다영"};
		String memo[] = {"아주 좋아요","좋아요","보통이에요","싫어요","아주 싫어요"};
		
		Random random = new Random();
		
		for (int i = 0; i < 100; i++) {
			
            int randomIndexName = random.nextInt(name.length);
            int randomIndexMemo = random.nextInt(memo.length);

            String ran = name[randomIndexName] + " " + memo[randomIndexMemo];
            vo.setGuestbook_name(name[randomIndexName]);
            vo.setGuestbook_memo(ran);
            service.guestbookInsert(vo);
		}
		return "/guestbookList.do";
	}
	
}
