package com.springbook.biz.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return dao.getProductList(vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return dao.getProduct(vo);
	}
	
	@Override
	public int getProductId() {
		return dao.getProductId();
	}

	@Override
	public void productInsert(ProductVO vo) {
		dao.productInsert(vo);
	}

	@Override
	public void productDelete(ProductVO vo) {
		dao.productDelete(vo);
	}

	@Override
	public void productUpdate(ProductVO vo) {
		dao.productUpdate(vo);
	}

	
	@Override
	public void shopInsert(BuyVO vo) {
		dao.shopInsert(vo);
	}
	
	@Override
	public void shopUpdate(BuyVO vo) {
		dao.shopUpdate(vo);
	}
	
	@Override
	public void shopDelete(BuyVO vo) {
		dao.shopDelete(vo);
	}
	
	@Override
	public void shopTotalDelete(BuyVO vo) {
		dao.shopTotalDelete(vo);
	}

	@Override
	public List<BuyVO> shopBuyList(BuyVO vo) {
		return dao.shopBuyList(vo);
	}

	@Override
	public BuyVO shopBuyCheck(BuyVO vo) {
		return dao.shopBuyCheck(vo);
	}

}
