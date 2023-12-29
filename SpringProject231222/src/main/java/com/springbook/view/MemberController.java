package com.springbook.view;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;

@Controller
@SessionAttributes("m")
public class MemberController {

	@Autowired
	private MemberService service;

	@RequestMapping(value="memberWrite.do", method=RequestMethod.GET)
	public String write(Model model) {
		
		model.addAttribute("member_id", service.getMemberId());
		
		return "/member/memberWrite.jsp";
	}
	
	@RequestMapping(value="memberWrite.do", method=RequestMethod.POST)
	public String write(MemberVO vo) throws IOException {

		service.insert(vo);
		
		return "memberList.do";
	}
	
	@RequestMapping(value="memberDelete.do")
	public String delete(MemberVO vo) {
		
		service.delete(vo);
		
		return "/memberList.do";
	}
	
	@RequestMapping(value="memberList.do")
	public String getProductList(Model model, MemberVO vo) {
		
		model.addAttribute("li", service.getMemberList(vo));
		
		return "/member/memberList.jsp";
	}
	
	@RequestMapping(value="memberOne.do")
	public String getMember(Model model, MemberVO vo) {
		
		model.addAttribute("m", service.getMember(vo));
		
		return "/member/memberOne.jsp";
	}
	
	@RequestMapping(value="memberUpdate.do")
	public String update(@ModelAttribute("m") MemberVO vo) throws IOException  {
		
		System.out.println("################################vo: " + vo);

		service.update(vo);
		
		return "/memberList.do";
	}
	
}
