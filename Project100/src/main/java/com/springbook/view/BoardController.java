package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	public BoardController() {
		System.out.println("==> BoardController 생성자");
	}
	
	@RequestMapping("/index.do")
	public String index() {
		System.out.println("==> index 메소드 확인");
		return "index.jsp";
	}
	 
	@RequestMapping(value="/write.do")
	public String write() {
		System.out.println("==> write 메소드 확인");
		return "/board/write.jsp";
	}
	
	@RequestMapping(value="/writeOk.do")
	public String writeOk(BoardVO vo) {
		System.out.println("==> writeOk 확인");
		service.insert(vo);
		return "/list.do";
	}
	
	@RequestMapping(value="list.do")
	public String list(Model model) {
		System.out.println("==> list 메소드 확인");
		model.addAttribute("li", service.getBoardList(null));
		return "/board/list.jsp";
	}
}
