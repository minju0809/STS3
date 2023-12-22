package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	List<BoardVO> getBoardList(String ch1, String ch2);
	BoardVO getBoard(BoardVO vo);
	
	void insert(BoardVO vo);
	void delete(BoardVO vo);
	void cntUpdate(BoardVO vo);
	void update(BoardVO vo);
}
