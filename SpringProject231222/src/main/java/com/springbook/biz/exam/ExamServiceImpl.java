package com.springbook.biz.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {
	
	@Autowired
	private ExamDao dao;

	@Override
	public List<ExamVO> getBoardList(ExamVO vo) {
		return dao.getBoardList(vo);
	}

}
