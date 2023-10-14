package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public BoardServiceImpl(){
	  System.out.println(" ===> BoardServiceImpl ");	
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}
	
	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}
}
