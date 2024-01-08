package com.jungbo.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		List<ExamVO> newLi = new ArrayList<>();
		
		
		for (int i = 0; i < li.size(); i++) {
			String color[] = {"silver", "gold", "palegoldenrod", "mediumslateblue", "mediumvioletred", "#e5e4e2", "#b87333", "#ffe4e2", "#e5ffe2", "#e5e4ff", "thistle", "honeydew", "cyan"};
			int randomIndex = (int)Math.floor(Math.random() * color.length);

			ExamVO m = li.get(i);
			
			int total = m.getKor() + m.getEng() + m.getMath() + m.getHist();
			int totalVal = (int) Math.round(total / 4.0);
			m.setSname(m.getSname());
			m.setTotalVal(totalVal);
			m.setColor(color[randomIndex]);
			
			newLi.add(m);
		}
		
		model.addAttribute("li", newLi);

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
	
	@RequestMapping(value = "/snameCk.do")
	public void snameCk(ExamVO vo, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		
		int sname = service.snameCk(vo);
		System.out.println("@@@@@@@@@@@@@sname:" + sname);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!vo" + vo);
		
		if (sname == 1) {
			out.print("F");
		} else {
			out.print("T");
		}
	}
	
}