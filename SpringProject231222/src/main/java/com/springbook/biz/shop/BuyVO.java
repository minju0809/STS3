package com.springbook.biz.shop;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BuyVO {
	private int cart_id;
	private String product_id;
	private String product_name;
	private int amount;
	private String memberId;
}
