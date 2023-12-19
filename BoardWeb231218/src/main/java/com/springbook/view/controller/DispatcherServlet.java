package com.springbook.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.springbook.biz.board.*;
import com.springbook.biz.board.impl.BoardServiceImpl;
import com.springbook.biz.user.*;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);

		if (path.equals("/login.do")) {
			System.out.println("로그인 처리");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);

			// UserDao dao = new UserDaoSpring();
			UserDao dao = new UserDaoImpl();
			UserVO user = dao.getUser(vo);
			System.out.println("user: " + user);

			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
			
		} else if (path.equals("/logout.do")) {
			System.out.println("로그아웃 처리");
			
		} else if (path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			
			request.setCharacterEncoding("utf-8");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);

			BoardService service = new BoardServiceImpl();
			service.insert(vo);

			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");

			BoardVO vo = new BoardVO();
			vo.setSeq(seq);
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			System.out.println("vo: "+vo);

			BoardService service = new BoardServiceImpl();
			service.update(vo);

			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			
			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardService service = new BoardServiceImpl();
			service.delete(seq);

			response.sendRedirect("getBoardList.do");
			
		} else if (path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			
			request.setCharacterEncoding("utf-8");

			int seq = Integer.parseInt(request.getParameter("seq"));

			BoardService service = new BoardServiceImpl();
			BoardVO m = service.getBoard(seq);
			
			HttpSession session = request.getSession();
			session.setAttribute("m", m);
			
			response.sendRedirect("getBoard.jsp");
			
		} else if (path.equals("/getBoardList.do")) {
			System.out.println("글 목록 검색 처리");
			
			BoardService service = new BoardServiceImpl();
			List<BoardVO> li = service.getBoardList();
			
			HttpSession session = request.getSession();
			session.setAttribute("li", li);
			
			response.sendRedirect("getBoardList.jsp");
		}
	}
}
