package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserDaoImpl;
import com.springbook.biz.user.UserVO;
import com.springbook.view.controller.Controller;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
//			response.sendRedirect("getBoardList.do");
			return "getBoardList.do";
		} else {
//			response.sendRedirect("login.jsp");
			return "login"; // do가 없을 것에는 ViewResolver에서 jsp 경로를 완성해줌
		}
	}

}
