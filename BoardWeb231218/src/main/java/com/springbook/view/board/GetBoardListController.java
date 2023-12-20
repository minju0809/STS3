package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;
import com.springbook.view.controller.Controller;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		BoardService service = new BoardServiceImpl();
		List<BoardVO> li = service.getBoardList();
		
		HttpSession session = request.getSession();
		session.setAttribute("li", li);
		 
		return "getBoardList";
	}

}
