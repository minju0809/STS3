package com.springbook.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardServiceImpl;

@Controller
public class BoardController {
	
	// @ModelAttribute 메소드의 실행 결과로 리턴된 객체는 자동으로 Model에 저장
	@ModelAttribute("map") // @RequestMapping 적용 메소드 보다 몬저 호출
	public Map<String, String> searchMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("제목", "title");
		map.put("내용", "content");
		return map;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value="ch1", defaultValue="title", required=false) String ch1, 
			@RequestParam(value="ch2", defaultValue="", required=false) String ch2, 
			BoardServiceImpl service, Model model) {
		// value: 화면으로부터 전달될 파라미터 이름
		// defaultValue: 화면으로부터 전달될 파라미터 정보가 없을 때, 설정할 기본값 - null에 대한 걱정 X
		// required: 파라미터의 생략 여부 
		System.out.println("글 목록 검색 처리");
		System.out.println("ch1(검색 조건): " + ch1 + ", ch2(검색 단어): " + ch2);
		
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
