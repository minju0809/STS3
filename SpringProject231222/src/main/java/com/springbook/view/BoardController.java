package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

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
	
	@RequestMapping(value="write.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("==> write");
		
		return "/board/write.jsp";
	}
	
	@RequestMapping(value="write.do", method=RequestMethod.POST)
	public String write(BoardVO vo) {
		System.out.println("==> write");
		
		service.insert(vo);
		
		return "/getBoardList.do";
	}
}
