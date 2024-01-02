package com.springbook.view;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.shop.BuyVO;
import com.springbook.biz.shop.ProductService;
import com.springbook.biz.shop.ProductVO;

@Controller
@SessionAttributes("m")
public class ShopController {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "shopBuy.do")
	public String buy(BuyVO buyVO, ProductVO productVO) {
		System.out.println("################################구매 확인");

		ProductVO pvo = service.getProduct(productVO);
		String product_name = pvo.getProduct_name();
		buyVO.setProduct_name(product_name);

		BuyVO checkVO = service.shopBuyCheck(buyVO);

		if (checkVO == null) {
			service.shopInsert(buyVO);
		} else {
			service.shopUpdate(buyVO);
		}

		return "/productList.do";
	}

	@RequestMapping(value="shopTotalUpdate.do")
	public String buyTotalUpdate(@RequestParam String[] memberId, 
			@RequestParam String[] cart_id, @RequestParam String[] amount){
		
		String memberIdStr = "";
		for (int i = 0; i < cart_id.length; i++) {
			BuyVO vo = new BuyVO();
			memberIdStr = memberId[0];
			vo.setMemberId(memberId[i]);
			vo.setCart_id(Integer.parseInt(cart_id[i]));
			vo.setAmount(Integer.parseInt(amount[i]));
			System.out.println("@@@@@@@@@@장바구니 업데이트 cart_id: " + Integer.parseInt(cart_id[i]) + ", amount: " +  Integer.parseInt(amount[i]));
			service.shopTotalUpdate(vo);
		}
		
		return "redirect:shopBuyList.do?memberId="+memberIdStr;
	}

	@RequestMapping(value = "shopRecordDelete.do")
	public String buyRecordDelete(BuyVO buyVO) {

		service.shopDelete(buyVO);

		return "/shopBuyList.do";
	}

	@RequestMapping(value = "shopTotalDelete.do")
	public String buyTotalDelete(BuyVO buyVO) {

		service.shopTotalDelete(buyVO);

		return "/shopBuyList.do";
	}

	@RequestMapping(value = "shopBuyList.do")
	public String buyList(Model model, BuyVO buyVO) {

		model.addAttribute("li", service.shopBuyList(buyVO));

		return "/shop/shopBuyList.jsp";
	}

}
