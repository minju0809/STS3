package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	public void insert(BoardVO vo);
	public void delete();
	public List<BoardVO> getBoardList();
	public BoardVO getBoard(int seq);
}
