package com.springbook.view.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;
import com.springbook.view.controller.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회 처리");

		try {
			request.setCharacterEncoding("utf-8");

			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardService service = new BoardServiceImpl();
			BoardVO m = service.getBoard(seq);

			HttpSession session = request.getSession();
			session.setAttribute("m", m);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "getBoard";
	}

}
