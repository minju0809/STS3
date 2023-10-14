package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	void insert(BoardVO vo);
	void delete(BoardVO vo);
	List<BoardVO> getBoardList();
}
