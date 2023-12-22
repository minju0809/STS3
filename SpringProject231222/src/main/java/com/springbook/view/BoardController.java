package com.springbook.view;

import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	public BoardController() {
		System.out.println("==> BoardController 생성자");
	}
	
	public String index() {
		
		return "index.jsp";
	}
}
