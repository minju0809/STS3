package com.springbook.biz.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDaoImpl dao;
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

}
