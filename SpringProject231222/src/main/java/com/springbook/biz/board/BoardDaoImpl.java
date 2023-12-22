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
	String select_writer_sql = "select * from board where writer like ? order by seq desc";
	String select_title_sql = "select * from board where title like ? order by seq desc";
	String select1_sql = "select * from board where seq = ?";
	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
	String delete_sql = "delete from board where seq = ?";
	String cnt_sql = "update board set cnt = (cnt+1) where seq = ?";

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		if (ch1 == null || ch2.equals("")) {
			return jdbcTemplate.query(select_sql, new BoardRowMapper());
		} else if (ch1.equals("writer")) {
			Object[] args = { "%" + ch2 + "%" };
			return jdbcTemplate.query(select_writer_sql, new BoardRowMapper(), args);
		} else if (ch1.equals("title")) {
			Object[] args = { "%" + ch2 + "%" };
			return jdbcTemplate.query(select_title_sql, new BoardRowMapper(), args);
		} else {
			return jdbcTemplate.query(select_sql, new BoardRowMapper());
		}
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		return jdbcTemplate.queryForObject(select1_sql, new BoardRowMapper(), args);
	}

	@Override
	public void insert(BoardVO vo) {
		Object[] args = { vo.getTitle(), vo.getWriter(), vo.getContent() };
		jdbcTemplate.update(insert_sql, args);
	}

	@Override
	public void delete(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		jdbcTemplate.update(delete_sql, args);
	}

	@Override
	public void cntUpdate(BoardVO vo) {
		Object[] args = { vo.getSeq() };
		jdbcTemplate.update(cnt_sql, args);
	}

}
