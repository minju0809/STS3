package com.springbook.biz.board;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoMybatis extends SqlSessionDaoSupport implements BoardDao {
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		System.out.println("===> Mybatis getBoardList");
		System.out.println("===> Mybatis CH1: " + ch1 + ", CH2: " + ch2);
		BoardVO vo = new BoardVO();
		vo.setCh1(ch1);
		vo.setCh2(ch2);
		
		if (ch2.equals("")) {
			return getSqlSession().selectList("BoardDao.select_sql");
		} else if (ch1.equals("writer")) {
			return getSqlSession().selectList("BoardDao.select_writer_sql", vo);
		} else if (ch1.equals("title")) {
			return getSqlSession().selectList("BoardDao.select_title_sql", vo);
		}
		return null;
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis getBoard");
		return (BoardVO) getSqlSession().selectOne("BoardDao.select1_sql", vo);
	}

	@Override
	public void insert(BoardVO vo) {
		System.out.println("===> Mybatis insert");
		getSqlSession().insert("BoardDao.insert_sql", vo);
	}

	@Override
	public void delete(BoardVO vo) {
		System.out.println("===> Mybatis delete");
		getSqlSession().delete("BoardDao.delete_sql", vo);
	}

	@Override
	public void cntUpdate(BoardVO vo) {
		System.out.println("===> Mybatis cntUpdate");
		getSqlSession().update("BoardDao.cnt_sql", vo);
	}

	@Override
	public void update(BoardVO vo) {
		System.out.println("===> Mybatis update");
		getSqlSession().update("BoardDao.update_sql", vo);
	}
	
}
