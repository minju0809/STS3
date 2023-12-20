package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	public void insert(BoardVO vo);
	public void delete();
	public void delete(BoardVO vo);
	public List<BoardVO> getBoardList();
	public BoardVO getBoard(BoardVO vo);
	public void update(BoardVO vo);
}
