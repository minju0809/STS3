package com.jungbo.biz.exam;

import java.util.List;

public interface ExamService {
	List<ExamVO> getExamList(ExamVO vo); 
	
	void ExamInsert(ExamVO vo);
	
	int snoCk(ExamVO vo);
	int snameCk(ExamVO vo);
}
