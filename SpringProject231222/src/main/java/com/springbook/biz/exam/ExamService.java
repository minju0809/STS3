package com.springbook.biz.exam;

import java.util.List;

public interface ExamService {
	List<ExamVO> getBoardList(ExamVO vo);
	
	void insert(ExamVO vo);
}
