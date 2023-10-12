package com.springbook.biz.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class InsertClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) container.getBean("boardService");
		
		int k = 4;
		BoardVO vo = new BoardVO();
		vo.setSeq(k);
		vo.setTitle("네번째테스트");
		vo.setWriter("병아리");
		vo.setContent("병아리의 노력");
		service.insert(vo);
		
		vo = service.getBoard(k);
		System.out.println(vo);
		
		container.close();
	}

}
