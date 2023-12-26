package com.springbook.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis implements BoardDao {
	
	@Autowired
	public SqlSessionTemplate mybatis;
	
	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		System.out.println("===> Mybatis getBoardList");
		System.out.println("===> Mybatis CH1: " + ch1 + ", CH2: " + ch2);
		BoardVO vo = new BoardVO();
		vo.setCh1(ch1);
		vo.setCh2(ch2);
		
		
//		if (ch2.equals("")) {
//			return mybatis.selectList("BoardDao.select_sql");
//		} else if (ch1.equals("writer")) {
//			return mybatis.selectList("BoardDao.select_writer_sql", vo);
//		} else if (ch1.equals("title")) {
//			return mybatis.selectList("BoardDao.select_title_sql", vo);
//		}
		
		return mybatis.selectList("BoardDao.select_ch_sql", vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard");
		return (BoardVO) mybatis.selectOne("BoardDao.select1_sql", vo);
	}

	@Override
	public void insert(BoardVO vo) {
		System.out.println("===> Mybatis insert");
		mybatis.insert("BoardDao.insert_sql", vo);
	}

	@Override
	public void delete(BoardVO vo) {
		System.out.println("===> Mybatis delete");
		mybatis.delete("BoardDao.delete_sql", vo);
	}

	@Override
	public void cntUpdate(BoardVO vo) {
		System.out.println("===> Mybatis cntUpdate");
		mybatis.update("BoardDao.cnt_sql", vo);
	}

	@Override
	public void update(BoardVO vo) {
		System.out.println("===> Mybatis update");
		mybatis.update("BoardDao.update_sql", vo);
	}
	
}
