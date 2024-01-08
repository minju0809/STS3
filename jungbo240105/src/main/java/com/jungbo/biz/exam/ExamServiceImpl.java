package com.jungbo.biz.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamDao dao;

	@Override
	public List<ExamVO> getExamList(ExamVO vo) {
		return dao.getExamList(vo);
	}

	@Override
	public void ExamInsert(ExamVO vo) {
		dao.ExamInsert(vo);
	}

	@Override
	public int snoCk(ExamVO vo) {
		return dao.snoCk(vo);
	}

	@Override
	public int snameCk(ExamVO vo) {
		return dao.snameCk(vo);
	}
	
}
