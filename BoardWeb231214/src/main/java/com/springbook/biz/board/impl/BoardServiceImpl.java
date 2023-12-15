package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//@Service("boardService")
public class BoardServiceImpl implements BoardService {

//	@Autowired
	private BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public void delete() {
		dao.delete();
	}

	@Override
	public int count() {
		return dao.count();
	}

}
