package com.springbook.view;

import java.io.IOException;
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
		
		int totalCount = service.getTotalCount(vo);
		
		int start = 0;
		int pageSize = 0;
		int pageListSize = 10;
		
		if (vo.getStart() == 0) {
			start = 1;
		} else {
			start = vo.getStart();
		}
		
		if(vo.getCh2() == null || vo.getCh2() == "") {
			pageSize = 15;
		} else {
			pageSize = 10;
		}
		
		int end = start + pageSize - 1;
		int totalPage = (totalCount / pageSize) + 1;
		int currentPage = (start / pageSize) + 1;
		int lastPage = (totalPage - 1) * pageSize + 1;  
		
	    int listStartPage = (currentPage - 1) / pageListSize * pageListSize + 1;
	    int listEndPage = listStartPage + pageListSize - 1 ;
		
		vo.setStart(start);
		vo.setPageSize(pageSize);
		vo.setEnd(end);

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("start", start);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("end", end);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		
		model.addAttribute("pageListSize", pageListSize);
		model.addAttribute("listStartPage", listStartPage);
		model.addAttribute("listEndPage", listEndPage);
		
		model.addAttribute("ch1", vo.getCh1());
		model.addAttribute("ch2", vo.getCh2());
		
		model.addAttribute("li", service.getGuestbookList(vo));

		return "/guestbook/guestbookList.jsp";
	}
	
	@RequestMapping(value = "guestbookWrite.do", method = RequestMethod.GET)
	public String guestbookWrite(GuestbookVO vo) {
		
		service.guestbookInsert(vo);
		
		return "guestbookList.do";
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
	
	@RequestMapping(value="guestbookDelete.do")
	public String guestbookDelete(GuestbookVO vo) {
		
		service.guestbookDelete(vo);
		
		return "/guestbookList.do";
	}
}
