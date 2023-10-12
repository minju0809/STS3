package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao dao;

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(int k) {
		dao.delete(k);
	}

	@Override
	public BoardVO getBoard(int k) {
		return dao.getBoard(k);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return dao.getBoardList();
	}

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		return dao.getBoardList(ch1, ch2);
	}
}
