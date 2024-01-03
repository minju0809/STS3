package com.springbook.biz.shop;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderVO {
	private int orderId;
	private int cart_id;
	private String memberId;
	private String product_id;
	private String product_name;
	private int amount;
	
	private String name;
	private String phone;
	private String etc;
	private String today;
}
