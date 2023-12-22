package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	public BoardController() {
		System.out.println("==> BoardController 생성자");
	}
	
	@RequestMapping(value="getBoardList.do")
	public String getBoardList(Model model) {
		System.out.println("==> getBoardList");
		
		model.addAttribute("li", service.getBoardList(null, null));
		
		return "/board/getBoardList.jsp";
	}
}
