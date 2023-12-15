package com.springbook.biz.board.client;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");

		BoardService boardService = (BoardService) container.getBean("boardService");

		// insert //
		BoardVO vo = new BoardVO();
		// vo.setSeq(103); // seq 쿼리로 받음
		vo.setTitle("도레미 겨울 여행");
		vo.setWriter("도레미");
		vo.setContent("도레미랑 여행 갈사람 손~~");

		boardService.insert(vo);
		
		// 레코드 수 select // 
//		int count = boardService.count();
//		System.out.println("count: " + count);
		
		// delete //
//		if (count > 7) {
//			for (int i = count; i >= 8; i--) {
//				boardService.delete();
//			}
//		}

		// select // 
		List<BoardVO> li = boardService.getBoardList();
		for (BoardVO m : li) {
			System.out.println(m);
		}

		container.close();
	}

}
