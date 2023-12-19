package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

//@Service("boardService")
public class BoardServiceImpl implements BoardService {

	private BoardDao dao = null;
	
//	@Autowired
//	private BoardDao dao;
	
//	@Autowired
//	private BoardDao dao;
//	private LogAdvice log;
//	private Log4jAdvice log;

	public BoardServiceImpl() {
		System.out.println("==> BoardServiceImpl 객체 생성(1)");
		dao = new BoardDaoImpl();
//		log = new Log4jAdvice();
	}

//	public void setDao(BoardDao dao) {
//		this.dao = dao;
//	}
//
//	public BoardServiceImpl(BoardDao dao) {
//		this.dao = dao;
//		System.out.println("==> BoardServiceImpl 객체 생성(2)");
//	} 
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public void delete() {
		 dao.delete();
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public BoardVO getBoard(int seq) {
		return dao.getBoard(seq);
	}

	@Override
	public void delete(int seq) {
		dao.delete(seq);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

}
