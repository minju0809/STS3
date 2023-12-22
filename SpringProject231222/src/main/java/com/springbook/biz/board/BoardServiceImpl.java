package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public BoardServiceImpl() {
		System.out.println("==> BoardServiceImpl 생성자");
	}

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		return dao.getBoardList(ch1, ch2);
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return dao.getBoard(vo);
	}

	@Override
	public void delete(BoardVO vo) {
		dao.delete(vo);
	}

	@Override
	public void cntUpdate(BoardVO vo) {
		dao.cntUpdate(vo);
	}
}
