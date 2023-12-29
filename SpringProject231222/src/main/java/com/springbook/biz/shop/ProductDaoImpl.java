package com.springbook.biz.shop;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Override
	public List<ProductVO> getProductList(ProductVO vo) {
		return mybatis.selectList("ProductDao.select_sql", vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		return mybatis.selectOne("ProductDao.select1_sql", vo);
	}
	
	@Override
	public int getProductId() {
		return mybatis.selectOne("ProductDao.selectId_sql");
	}

	@Override
	public void productInsert(ProductVO vo) {
		mybatis.insert("ProductDao.insert_sql", vo);
	}

	@Override
	public void productDelete(ProductVO vo) {
		mybatis.delete("ProductDao.delete_sql", vo);
	}

	@Override
	public void productUpdate(ProductVO vo) {
		mybatis.update("ProductDao.update_sql", vo);
	}

	@Override
	public void shopInsert(BuyVO vo) {
		mybatis.insert("ProductDao.shopInsert_sql", vo);
	}

}
