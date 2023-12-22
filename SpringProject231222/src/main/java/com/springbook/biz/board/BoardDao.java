package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	List<BoardVO> getBoardList(BoardVO vo);
	BoardVO getBoard(BoardVO vo);
	
	void insert(BoardVO vo);
	void delete(BoardVO vo);
	void cntUpdate(BoardVO vo);
}
