package com.springbook.biz.board.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVO;

@Repository
public class BoardDaoSpring implements BoardDao {
//public class BoardDaoSpring extends JdbcDaoSupport implements BoardDao {
	
	public BoardDaoSpring() {
		System.out.println("@@@@@@@@@@@@@==> BoardDaoSpring 객체 생성");
	}

	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
//	String insert_sql = "insert into board (seq, title, writer, content) "
//			+ " values (?,?,?,?)";
	String select_sql = "select * from board order by seq";
	String select1_sql = "select * from board where seq=?";
	String delete_sql = "delete from board where seq=(select min(seq) as seq from board)";
	String delete1_sql = "delete from board where seq=?";
	String update_sql = "update board set title=?, writer=?, content=? where seq=?";

	// 2. 상속을 안 받는 경우 - 주로 사용되는 방법
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<BoardVO> getBoardList() {
		return jdbcTemplate.query(select_sql, new BoardRowMapper());
	}
	
	@Override
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(select1_sql, new BoardRowMapper(), args);
	}
	
	@Override
	public void insert(BoardVO vo) {
		Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(insert_sql, args);
	}

	@Override
	public void delete() {
		jdbcTemplate.update(delete_sql);		
	}
	
	@Override
	public void delete(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		jdbcTemplate.update(delete1_sql, new BoardRowMapper(), args);
	}

	@Override
	public void update(BoardVO vo) {
		
	}

	
	// 1. 상속을 받는 경우
	
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
//	@Override
//	public void insert(BoardVO vo) {
//		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
//		getJdbcTemplate().update(insert_sql, args);
//	}
//
//	@Override
//	public void delete() {
//		getJdbcTemplate().update(delete_sql);		
//	}
//
//	@Override
//	public List<BoardVO> getBoardList() {
//		return getJdbcTemplate().query(select_sql, new BoardRowMapper());
//	}
//
//	@Override
//	public BoardVO getBoard(int seq) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

