package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.shop.BuyVO;
import com.springbook.biz.shop.ProductService;

@Controller
@SessionAttributes("m")
public class ShopController {

	@Autowired
	private ProductService service;

	@RequestMapping(value="shopBuy.do")
	public String buy(BuyVO vo){
		System.out.println("################################구매 확인");
		System.out.println("################################vo: " + vo);
		
		return "/productList.do";
	}
	
		
}
