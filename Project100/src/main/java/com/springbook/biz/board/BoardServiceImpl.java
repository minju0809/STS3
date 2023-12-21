package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	public BoardServiceImpl() {
		System.out.println("==> BoardServiceImpl 객체 생성(1)");
	}
	
	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return dao.getBoardList(vo);
	}

}
