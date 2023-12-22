package com.springbook.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("m")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	public BoardController() {
		System.out.println("==> BoardController 생성자");
	}
	
	@ModelAttribute("ch1")
	public Map<String, String> ch1() {
		Map<String, String> ch1 = new HashMap<>();
		ch1.put("작성자", "writer");
		ch1.put("제목", "title");
		return ch1;
	}
	
	@RequestMapping(value="getBoardList.do")
	public String getBoardList(
			@RequestParam(value="ch1", defaultValue="writer", required=false) String ch1,
			@RequestParam(value="ch2", defaultValue="", required=false) String ch2,
			Model model) {
		System.out.println("==> getBoardList");
		
		model.addAttribute("li", service.getBoardList(ch1, ch2));
		
		return "/board/getBoardList.jsp";
	}
	
	@RequestMapping(value="detail.do")
	public String getBoard(Model model, BoardVO vo) {
		System.out.println("==> getBoard");
		
		service.cntUpdate(vo);
		model.addAttribute("m", service.getBoard(vo));
		
		return "/board/detail.jsp";
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
	
	@RequestMapping(value="delete.do")
	public String delete(BoardVO vo) {
		System.out.println("==> delete");
		
		service.delete(vo);
		
		return "/getBoardList.do";
	}
	
	@RequestMapping(value="update.do")
	public String update(@ModelAttribute("m") BoardVO vo) {
		System.out.println("==> update 확인" + vo);
		
		service.update(vo);
		
		return "/getBoardList.do";
	}
}
