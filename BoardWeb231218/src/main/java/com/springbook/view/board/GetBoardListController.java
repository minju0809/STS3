package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;
//import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> li = service.getBoardList();
		
//		HttpSession session = request.getSession();
//		session.setAttribute("li", li);
		 
		ModelAndView mav = new ModelAndView();
		mav.addObject("li", li); // Model 정보 저장
		mav.setViewName("getBoardList"); // View 정보 저장

		return mav;
	}

}
