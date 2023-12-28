package com.springbook.biz.shop;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductVO {
	private int product_id;
	private String product_name;
	private int product_price;
	private String product_desc;
	private MultipartFile product_img_file;
	private String product_img;
}
