package com.springbook.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardServiceImpl;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardServiceImpl service;

	public BoardController() {
		System.out.println("===> BoardController 확인");
	}

	@RequestMapping("/insertBoard.do")
	public String insert(BoardVO vo) {
		service.insert(vo);
		System.out.println("===> insertBoard.do 매핑확인 ");
		return "getBoardList.do";
	}
	
	@RequestMapping("/delete.do")
	public String delete(BoardVO vo) {
		service.delete(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) {
		mav.addObject("boardList", service.getBoardList());
		System.out.println("===> @@@@@@@@@@2 getBoardList.do 매핑확인 ");
		mav.setViewName("getBoardList.jsp");
		return mav;
	}
}
