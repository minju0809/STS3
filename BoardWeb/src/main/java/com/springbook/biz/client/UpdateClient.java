package com.springbook.biz.client;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class UpdateClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) container.getBean("boardService");

		int k = 4;
		BoardVO vo = service.getBoard(k);
		System.out.println("수정 전 : " + vo);

		vo.setSeq(k);
		vo.setTitle("또또수정");
		vo.setWriter("닭");
		vo.setContent("닭의 노력");

		service.update(vo);
		System.out.println("---[수정 완료]---");

		vo = service.getBoard(k);
		System.out.println("수정 후 : " + vo);

		container.close();
	}

}
