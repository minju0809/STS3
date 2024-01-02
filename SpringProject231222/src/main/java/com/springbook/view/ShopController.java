package com.springbook.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.shop.BuyVO;
import com.springbook.biz.shop.ProductService;
import com.springbook.biz.shop.ProductVO;

@Controller
@SessionAttributes("m")
public class ShopController {

	@Autowired
	private ProductService service;

	@RequestMapping(value="shopBuy.do")
	public String buy(BuyVO buyVO, ProductVO productVO){
		System.out.println("################################구매 확인");
		
		ProductVO pvo = service.getProduct(productVO);
		buyVO.setProduct_name(pvo.getProduct_name());
		service.shopInsert(buyVO);
		
		return "/productList.do";
	}
	
	@RequestMapping(value="shopBuyList.do")
	public String buyList(Model model, BuyVO buyVO){
		
		model.addAttribute("li", service.shopBuyList(buyVO));
		
		return "/shop/shopBuyList.jsp";
	}
}
