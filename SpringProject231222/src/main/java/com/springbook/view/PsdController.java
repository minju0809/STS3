package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.psd.PsdVO;


@Controller
public class PsdController {
	
	@RequestMapping(value="psdList.do")
	public String getBoardList(Model model) {
		System.out.println("==> getBoardList");
		
//		model.addAttribute("li", service.getBoardList(vo));
		
		return "/psd/psdList.jsp";
	}

	@Autowired
//	private PsdService service;
	
	@RequestMapping(value="psdWrite.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("==> write");
		
		return "/psd/psdWrite.jsp";
	}
	
	@RequestMapping(value="psdWrite.do", method=RequestMethod.POST)
	public String write(PsdVO vo) {
		System.out.println("==> write");
		
//		service.insert(vo);
		
		return "/psd/psdList.jsp";
	}
}
