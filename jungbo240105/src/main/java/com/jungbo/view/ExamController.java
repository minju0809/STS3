package com.jungbo.view;

import java.util.List;

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
		
//	    for (ExamVO exam : li) {
//	        int sum = exam.getKor() + exam.getEng() + exam.getMath() + exam.getHist();
//	        double avg = (exam.getKor() + exam.getEng() + exam.getMath() + exam.getHist()) / (double)4.0;
//	        exam.setSum(sum);
//	        exam.setAvg(avg);
//	        
//	        if (exam.getAvg() >= 90) {
//	        	exam.setGrade("수");
//	        } else if (exam.getAvg() >= 80) {
//	        	exam.setGrade("우");
//	        } else if (exam.getAvg() >= 70) {
//	        	exam.setGrade("미");
//	        } else if (exam.getAvg() < 70) {
//	        	exam.setGrade("재시험");
//	        }
//	    }
		
		model.addAttribute("li", li);

		return "/exam/examList.jsp";
	}
}
