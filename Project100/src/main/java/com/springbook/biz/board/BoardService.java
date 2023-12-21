package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	public void insert(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
//	public void delete(BoardVO vo);
//	public BoardVO getBoard(BoardVO vo);
//	public void update(BoardVO vo);
}
