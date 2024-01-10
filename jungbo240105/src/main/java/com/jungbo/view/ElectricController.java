package com.jungbo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jungbo.biz.electric.ElectricService;
import com.jungbo.biz.electric.ElectricVO;

@Controller
public class ElectricController {

	@Autowired
	private ElectricService service;

	@RequestMapping(value = "/electricList.do", method=RequestMethod.GET)
	public String electricList(Model model, ElectricVO vo) {
		
		model.addAttribute("li", service.getElectricList(vo));
		

		return "/electric/electricList.jsp";
	}
	
	@RequestMapping(value = "/electricMap1.do", method=RequestMethod.GET)
	public String electricMap1(Model model, ElectricVO vo) {
		
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("li", service.getElectricList(vo));

		return "/electric/electricMap1.jsp";
	}
	
	@RequestMapping(value = "/OpenSelectOneMap.do", method=RequestMethod.GET)
	public String OpenSelectOneMap(Model model, ElectricVO vo) {
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("m", service.getElectricOne(vo));
		model.addAttribute("memo", service.getMemoList(vo));
		
		return "/electric/openSelectOneMap.jsp";
	}
	
	@RequestMapping(value = "/memoInsert.do")
	public String electricInsert(ElectricVO vo) {
		
		service.insert(vo);

		return "/OpenSelectOneMap.do?idx=" + vo.getGangwonIdx();
	}
	
	@RequestMapping(value = "/electricMap2.do", method=RequestMethod.GET)
	public String electricMap2(Model model, ElectricVO vo) {
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("li", service.getElectricList(vo));

		return "/electric/electricMap2.jsp";
	}
	
}

