package com.springbook.biz.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class SelectFilterClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) container.getBean("boardService");

		String ch1 = "writer";
		String ch2 = "병아리";
		List<BoardVO> li = service.getBoardList(ch1, ch2);

		for (int i = 0; i < li.size(); i++) {
			BoardVO vo = li.get(i);
			System.out.println(vo);
		}
		container.close();
	}

}
