package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserDaoImpl;
import com.springbook.biz.user.UserVO;
//import com.springbook.view.controller.Controller;
//import com.springbook.view.board.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {	
//	public String loginView(UserVO vo) {
		System.out.println("로그인 화면으로 이동");

		vo.setId("user1");
		vo.setPassword("user1");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDaoImpl dao, HttpSession session) {
		System.out.println("로그인 인증 처리");

		UserVO user = dao.getUser(vo);

		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
