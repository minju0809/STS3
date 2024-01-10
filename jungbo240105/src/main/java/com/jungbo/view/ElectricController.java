package com.jungbo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jungbo.biz.electric.ElectricService;
import com.jungbo.biz.electric.ElectricVO;

@Controller
public class ElectricController {

	@Autowired
	private ElectricService service;

	@RequestMapping(value = "/electricList.do", method=RequestMethod.GET)
	public String guestbookList(Model model, ElectricVO vo) {
		
		model.addAttribute("li", service.getElectricList(vo));
		

		return "/electric/electricList.jsp";
	}
	
	@RequestMapping(value = "/electricMap1.do", method=RequestMethod.GET)
	public String guestbookMap1(Model model, ElectricVO vo) {
		
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("li", service.getElectricList(vo));

		return "/electric/electricMap1.jsp";
	}
	
	@RequestMapping(value = "/electricMap2.do", method=RequestMethod.GET)
	public String guestbookMap2(Model model, ElectricVO vo) {
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		
	    ObjectMapper objectMapper = new ObjectMapper();
	    try {
	        String electricListJson = objectMapper.writeValueAsString(service.getElectricList(vo));
	        model.addAttribute("li", electricListJson);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		model.addAttribute("li", service.getElectricList(vo));

		return "/electric/electricMap2.jsp";
	}
	
}
