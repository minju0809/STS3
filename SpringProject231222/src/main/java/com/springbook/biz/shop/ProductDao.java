package com.springbook.biz.shop;

import java.util.List;

public interface ProductDao {
	List<ProductVO> getProductList(ProductVO vo);
	ProductVO getProduct(ProductVO vo);
	int getProductId();
	
	void productInsert (ProductVO vo);
	void productDelete (ProductVO vo);
	void productUpdate (ProductVO vo);
	
	void shopInsert(BuyVO vo);
}
