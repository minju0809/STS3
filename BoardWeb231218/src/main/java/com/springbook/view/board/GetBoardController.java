package com.springbook.view.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;
//import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");

		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardService service = new BoardServiceImpl();
		BoardVO m = service.getBoard(seq);

//		HttpSession session = request.getSession();
//		session.setAttribute("m", m);

		ModelAndView mav = new ModelAndView();
		mav.addObject("m", m); // Model 정보 저장
		mav.setViewName("getBoard"); // View 정보 저장

		return mav;
	}

}
