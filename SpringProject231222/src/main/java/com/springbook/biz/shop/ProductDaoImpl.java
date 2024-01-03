package com.springbook.biz.shop;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.member.MemberVO;

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
	
	@Override
	public void shopUpdate(BuyVO vo) {
		mybatis.update("ProductDao.shopUpdate_sql", vo);
	}
	
	@Override
	public void shopTotalUpdate(BuyVO vo) {
		mybatis.update("ProductDao.shopTotalUpdate_sql", vo);
	}
	
	@Override
	public void shopDelete(BuyVO vo) {
		mybatis.delete("ProductDao.shopDelete_sql", vo);
	}
	
	@Override
	public void shopTotalDelete(BuyVO vo) {
		mybatis.delete("ProductDao.shopTotalDelete_sql", vo);
	}

	@Override
	public List<BuyVO> shopBuyList(BuyVO vo) {
		return mybatis.selectList("ProductDao.shopBuyList_sql", vo);
	}

	@Override
	public BuyVO shopBuyCheck(BuyVO vo) {
		return mybatis.selectOne("ProductDao.shopBuyCK_sql", vo);
	}

	@Override
	public int orderIdx() {
		return mybatis.selectOne("ProductDao.orderIdx_sql");
	}

	@Override
	public void orderMemberInsert(OrderVO vo) {
		mybatis.insert("ProductDao.orderMemberInsert_sql", vo);
	}

	@Override
	public void orderInsert(OrderVO vo) {
		mybatis.insert("ProductDao.orderInsert_sql", vo);
	}

	@Override
	public List<OrderVO> orderMemberList(OrderVO vo) {
		return mybatis.selectList("ProductDao.orderMemeberList_sql", vo);
	}

	@Override
	public List<OrderVO> orderList(OrderVO vo) {
		return mybatis.selectList("ProductDao.orderList_sql", vo);
	}

	@Override
	public MemberVO orderMember(OrderVO vo) {
		return mybatis.selectOne("ProductDao.orderMember_sql", vo);
	}
	
}
