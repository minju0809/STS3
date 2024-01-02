package com.springbook.biz.shop;

import java.util.List;

public interface ProductService {
	List<ProductVO> getProductList(ProductVO vo);
	ProductVO getProduct(ProductVO vo);
	int getProductId();
	
	void productInsert (ProductVO vo);
	void productDelete (ProductVO vo);
	void productUpdate (ProductVO vo);
	
	void shopInsert(BuyVO vo);
	void shopDelete(BuyVO vo);
	List<BuyVO> shopBuyList(BuyVO vo);
}
