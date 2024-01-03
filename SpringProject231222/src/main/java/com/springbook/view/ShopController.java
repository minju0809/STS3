package com.springbook.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springbook.biz.member.MemberService;
import com.springbook.biz.member.MemberVO;
import com.springbook.biz.shop.BuyVO;
import com.springbook.biz.shop.OrderVO;
import com.springbook.biz.shop.ProductService;
import com.springbook.biz.shop.ProductVO;

@Controller
@SessionAttributes("m")
public class ShopController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private MemberService memberService;

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
	
	@RequestMapping(value = "shopOrderAll.do")
	public String shopOrderAll(
			@RequestParam String[] memberId, 
			@RequestParam String[] cart_id, 
			@RequestParam String[] amount,
			@RequestParam String[] product_id,
			@RequestParam String[] product_name) {
		
		String memberIdStr = "";
		
		int orderIdx = service.orderIdx();
		
		for (int i = 0; i < cart_id.length; i++) {
			OrderVO vo = new OrderVO();
			memberIdStr = memberId[0];
			vo.setMemberId(memberId[i]);
			vo.setCart_id(Integer.parseInt(cart_id[i]));
			vo.setAmount(Integer.parseInt(amount[i]));
			vo.setProduct_id(product_id[i]);
			vo.setProduct_name(product_name[i]);
			vo.setOrderId(orderIdx);
			
			service.orderInsert(vo);
		}
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberIdStr);
		
		memberVO = memberService.getMember(memberVO);
		
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderId(orderIdx);
		orderVO.setName(memberVO.getName());
		if (memberVO.getPhone() == null) {
			orderVO.setPhone(" ");
		} else {
			orderVO.setPhone(memberVO.getPhone());
		}
		orderVO.setEtc(" ");
		service.orderMemberInsert(orderVO);
		
		BuyVO buyVO = new BuyVO();
		buyVO.setMemberId(memberIdStr);
		service.shopTotalDelete(buyVO);
		
		return "redirect:index.do";
	}

	@RequestMapping(value = "orderMemberList.do")
	public String orderMemberList(Model model, OrderVO orderVO) {

		model.addAttribute("li", service.orderMemberList(orderVO));

		return "/shop/orderMemberList.jsp";
	}
	
	@RequestMapping(value = "orderList.do")
	public String orderList(Model model, OrderVO orderVO) {
		
		model.addAttribute("li", service.orderList(orderVO));
		model.addAttribute("orderMember", service.orderMember(orderVO));
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!orderVO: " + service.orderMember(orderVO));
		
		return "/shop/orderList.jsp";
	}

}
