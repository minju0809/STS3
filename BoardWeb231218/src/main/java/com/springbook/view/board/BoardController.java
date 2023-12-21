package com.springbook.view.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardServiceImpl service, Model model) {
		System.out.println("글 목록 검색 처리");
		
//		HttpSession session = request.getSession();
//		session.setAttribute("li", li);
		
		model.addAttribute("li", service.getBoardList()); // Model 정보 저장
		
		return "getBoardList.jsp";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardServiceImpl service, Model model) {
		System.out.println("글 상세 조회 처리");

		model.addAttribute("m", service.getBoard(vo)); // Model 정보 저장

		return "getBoard.jsp";
	}
	
////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardServiceImpl service) { // 커맨드화
		System.out.println("글 등록 처리");
		
		service.insert(vo);
		
		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardServiceImpl service) {
		System.out.println("글 삭제 처리");

		service.delete(vo);

		return "redirect:getBoardList.do";
	}

	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardServiceImpl service) {
		System.out.println("글 수정 처리");

		service.update(vo);

		return "getBoardList.do";
	}

}
