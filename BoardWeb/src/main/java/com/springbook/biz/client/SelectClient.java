package com.springbook.biz.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class SelectClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) container.getBean("boardService");

		int k = 2;
		BoardVO vo = service.getBoard(k);
		System.out.println(vo);

		container.close();
	}

}
