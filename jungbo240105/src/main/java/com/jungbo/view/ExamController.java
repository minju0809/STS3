package com.jungbo.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jungbo.biz.exam.ExamService;
import com.jungbo.biz.exam.ExamVO;

@Controller
public class ExamController {
	
	@Autowired
	private ExamService service;
	
	@RequestMapping(value = "/examList.do", method=RequestMethod.GET)
	public String examList(Model model, ExamVO vo) {
		
		List<ExamVO> li = service.getExamList(vo);
		
		model.addAttribute("li", li);

		return "/exam/examList.jsp";
	}
	
	@RequestMapping(value = "/examInsert.do", method=RequestMethod.GET)
	public String examInsert() {
		
		return "/exam/examInsert.jsp";
	}
	
	@RequestMapping(value = "/examInsert.do", method=RequestMethod.POST)
	public String examInsert(ExamVO vo) {
		
		service.ExamInsert(vo);
		
		return "redirect:/examList.do";
	}
	
	@RequestMapping(value = "/snoCk.do")
	public void snoCk(ExamVO vo, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		int sno = service.snoCk(vo);
		System.out.println("@@@@@@@@@@@@@sno:" + sno);
		int getSno = Integer.parseInt(vo.getSno());
		System.out.println("^^^^^^^^@@sno" + getSno);
		if (sno == 1) {
			out.print("F");
		} else {
			out.print("T");
		}
	}
	
	
	
}