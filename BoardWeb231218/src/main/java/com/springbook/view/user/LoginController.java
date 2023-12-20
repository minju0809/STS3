package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserDao;
import com.springbook.biz.user.UserDaoImpl;
import com.springbook.biz.user.UserVO;
//import com.springbook.view.controller.Controller;
//import com.springbook.view.board.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDaoImpl dao) {
		System.out.println("로그인 처리");

		UserVO user = dao.getUser(vo);
		
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}

}
