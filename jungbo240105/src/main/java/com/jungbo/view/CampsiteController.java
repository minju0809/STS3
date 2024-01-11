package com.jungbo.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jungbo.biz.campsite.CampsiteService;
import com.jungbo.biz.campsite.CampsiteVO;

@Controller
public class CampsiteController {

	@Autowired
	private CampsiteService service;

	@RequestMapping(value = "/campsiteList.do", method=RequestMethod.GET)
	public String campsiteList(Model model, CampsiteVO vo) {
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("li", service.getCampsiteList(vo));

		return "/campsite/campsiteList.jsp";
	}
	
	@RequestMapping(value = "/campsiteOne.do", method=RequestMethod.GET)
	public String campsiteOne(Model model, CampsiteVO vo) {
		
		model.addAttribute("keyValue", "5fd42cdd845577dc157f2510c3e96a73");
		model.addAttribute("m", service.getCampsiteOne(vo));

		return "/campsite/campsiteOne.jsp";
	}
}
