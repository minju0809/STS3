package com.springbook.biz.board.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(101);
		vo.setTitle("하늘이 설악산");
		vo.setWriter("하늘이");
		vo.setContent("설악산 종주 같이 갈사람 손~~");
		boardService.insert(vo);
		
		container.close();
	}

}
