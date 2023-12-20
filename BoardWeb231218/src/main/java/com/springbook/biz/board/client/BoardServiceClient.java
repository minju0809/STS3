//package com.springbook.biz.board.client;
//
//import java.util.List;
//
//import org.springframework.context.support.AbstractApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//
//import com.springbook.biz.board.BoardService;
//import com.springbook.biz.board.BoardVO;
//
//public class BoardServiceClient {
//
//	public static void main(String[] args) {
//		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
//
//		BoardService boardService = (BoardService) container.getBean("boardService");
//
//		// insert //
////		BoardVO vo = new BoardVO();
////		vo.setSeq(100);
////		vo.setTitle("나나 겨울 여행");
////		vo.setWriter("나나");
////		vo.setContent("나나랑 여행 갈사람 손~~");
//
////		boardService.insert(vo);
//
//		// select // 
//		List<BoardVO> li = boardService.getBoardList();
//		for (BoardVO m : li) {
//			System.out.println(m);
//		}
//		
//		// select1 //
//		int seq = 108;
//		BoardVO board = boardService.getBoard(seq);
//		System.out.println("상세보기: " + board); 
//
//		container.close();
//	}
//
//}
