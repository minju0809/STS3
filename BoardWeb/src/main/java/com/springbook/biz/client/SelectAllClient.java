package com.springbook.biz.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class SelectAllClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) container.getBean("boardService");

		List<BoardVO> li = service.getBoardList();

		for (int i = 0; i < li.size(); i++) {
			BoardVO vo = li.get(i);
			System.out.println(vo);
		}
		container.close();
	}
}
