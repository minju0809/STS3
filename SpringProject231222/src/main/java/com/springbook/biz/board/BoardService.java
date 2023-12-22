package com.springbook.biz.board;

import java.util.List;

public interface BoardService {
	List<BoardVO> getBoardList(String ch1, String ch2);
}
