package com.springbook.biz.shop;

import org.springframework.web.multipart.MultipartFile;

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
	
	private int product_price;
	private String product_img;
	private MultipartFile product_img_file;
}
