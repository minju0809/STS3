package com.springbook.biz.shop;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BuyVO {
	private String product_id;
	private int amount;
	private String memberId;
}
