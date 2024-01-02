package com.springbook.view;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.springbook.biz.member.BCrypt;
import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Controller
@SessionAttributes("m")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value = "memberLogin.do", method = RequestMethod.GET)
	public String login(Model model) {

		return "/member/memberLogin.jsp";
	}

	@RequestMapping(value = "memberLogin.do", method = RequestMethod.POST)
	public String login(MemberVO vo, Model model, HttpSession session) throws IOException {

		MemberVO m = service.getMemberLogin(vo);
		System.out.println("########## m: " + m);

		session.setAttribute("login", m);

		if (m != null) {
			if (BCrypt.checkpw(vo.getPwd(), m.getPwd())) {
				model.addAttribute("loginVO", service.getMemberLogin(vo));

				System.out.println("@@@@@@@@@@일치");
				return "/member/memberLoginSuccess.jsp";
			} else {
				System.out.println("@@@@@@@@@@@불일치");
				return "/member/memberLogin.jsp";
			}
		}
		return "/member/memberLogin.jsp";
	}
	
	@RequestMapping(value = "memberLogout.do")
	public String logout(MemberVO vo, Model model, HttpSession session) throws IOException {

		session.invalidate();
		
		return "/member/memberLogin.jsp";
	}

	@RequestMapping(value = "memberWrite.do", method = RequestMethod.GET)
	public String write(Model model) {

		model.addAttribute("member_id", service.getMemberId());

		return "/member/memberWrite.jsp";
	}

	@RequestMapping(value = "memberWrite.do", method = RequestMethod.POST)
	public String write(MemberVO vo) throws IOException {

		String Bqwd = BCrypt.hashpw(vo.getPwd(), BCrypt.gensalt());
		vo.setPwd(Bqwd);
		service.insert(vo);

		return "memberList.do";
	}

	@RequestMapping(value = "memberDelete.do")
	public String delete(MemberVO vo) {

		service.delete(vo);

		return "/memberList.do";
	}

	@RequestMapping(value = "memberList.do")
	public String getProductList(Model model, MemberVO vo) {

		model.addAttribute("li", service.getMemberList(vo));

		return "/member/memberList.jsp";
	}

	@RequestMapping(value = "memberOne.do")
	public String getMember(Model model, MemberVO vo) {

		model.addAttribute("m", service.getMember(vo));

		return "/member/memberOne.jsp";
	}

	@RequestMapping(value = "memberUpdate.do")
	public String update(@ModelAttribute("m") MemberVO vo) throws IOException {

		System.out.println("################################vo: " + vo);

		service.update(vo);

		return "/memberList.do";
	}

}
