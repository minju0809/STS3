package com.springbook.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.exam.ExamService;
import com.springbook.biz.exam.ExamVO;

@Controller
@SessionAttributes("m")
public class ExamController {

	@Autowired
	private ExamService service;
	
	public ExamController() {
	}
	
	@ModelAttribute("ch1")
	public Map<String, String> ch1() {
		Map<String, String> ch1 = new HashMap<>();
		ch1.put("학번", "sno");
		ch1.put("이름", "sname");
		return ch1;
	}
	
	@RequestMapping(value="examList.do")
	public String getBoardList(
			@RequestParam(value="ch1", defaultValue="sno", required=false) String ch1,
			@RequestParam(value="ch2", defaultValue="", required=false) String ch2,
			Model model) {
		System.out.println("==> getBoardList");
		
		ExamVO vo = new ExamVO();
		vo.setCh1(ch1);
		vo.setCh2(ch2);
		
		model.addAttribute("li", service.getBoardList(vo));
		
		return "/exam/examList.jsp";
	}
	
	@RequestMapping(value="examWrite.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("==> write");
		
		return "/exam/examWrite.jsp";
	}
	
	@RequestMapping(value="examWrite.do", method=RequestMethod.POST)
	public String write(ExamVO vo) {
		System.out.println("==> write");
		
		service.insert(vo);
		
		return "/examList.do";
	}
}
