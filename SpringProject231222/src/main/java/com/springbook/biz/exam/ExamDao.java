package com.springbook.biz.exam;

import java.util.List;


public interface ExamDao {
	List<ExamVO> getBoardList(ExamVO vo);
	
	void insert(ExamVO vo);
}
