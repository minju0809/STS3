package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	String select_sql = "select * from board order by seq desc";
	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
	
	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		// Object[] args = { ch1, ch2 };
		return jdbcTemplate.query(select_sql, new BoardRowMapper());
	}

	@Override
	public void insert(BoardVO vo) {
		Object[] args = { vo.getTitle(), vo.getWriter(), vo.getContent() };
		jdbcTemplate.update(insert_sql, args);
	}

}
