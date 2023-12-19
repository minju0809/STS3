package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	public void insert(BoardVO vo);
	public void delete();
	public void delete(int seq);
	public List<BoardVO> getBoardList();
	public BoardVO getBoard(int seq);
	public void update(BoardVO vo);
}
