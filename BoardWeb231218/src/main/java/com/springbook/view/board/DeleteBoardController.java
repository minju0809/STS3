package com.springbook.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.impl.BoardServiceImpl;
import com.springbook.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 삭제 처리");
		
		int seq = Integer.parseInt(request.getParameter("seq"));

		BoardService service = new BoardServiceImpl();
		service.delete(seq);

		return "getBoardList.do";
	}

}
