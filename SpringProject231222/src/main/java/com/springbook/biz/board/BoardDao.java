package com.springbook.biz.board;

import java.util.List;

public interface BoardDao {
	List<BoardVO> getBoardList(String ch1, String ch2);
}
