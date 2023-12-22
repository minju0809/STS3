package com.springbook.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	public IndexController() {
		System.out.println("==> IndexController 생성자");
	}
	
	@RequestMapping(value="index.do")
	public String index() {
		System.out.println("index.do 확인");
		return "index.jsp";
	}
}
