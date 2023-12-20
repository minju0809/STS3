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
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;

	public DispatcherServlet() {
		super();
//		System.out.println("==> DispatcherServlet");
	}
	
	public void init() throws ServletException { // 초기화
		System.out.println("==> init");
		
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
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
		// 클라이언트의 요청 path 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// HandlerMapping을 통해 path에 해당하는 Controller를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		// 검색된 Controller 실행
		String viewName = ctrl.handleRequest(request, response);
		
		// ViewReslover를 통해 viewName에 해당하는 화면을 검색
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		} else {
			view = viewName;
		}
		
		// 검색된 화면으로 이동
		response.sendRedirect(view);
		
		// 각 Controller로 이동
//		if (path.equals("/login.do")) {
//		} else if (path.equals("/logout.do")) {
//		} else if (path.equals("/insertBoard.do")) {
//		} else if (path.equals("/updateBoard.do")) {
//		} else if (path.equals("/deleteBoard.do")) {
//		} else if (path.equals("/getBoard.do")) {
//		} else if (path.equals("/getBoardList.do")) {
//		}
	}
}
