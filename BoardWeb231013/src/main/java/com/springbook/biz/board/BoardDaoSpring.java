package com.springbook.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoSpring implements BoardDao {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public void insert(BoardVO vo) {
		String SQL = "insert into board (seq, title, writer, content) values (?,?,?,?)";
		jdbc.update(SQL, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}

	@Override
	public void delete(BoardVO vo) {
		String SQL = "delete from board where seq=?";
		jdbc.update(SQL, vo.getSeq());
	}

	@Override
	public List<BoardVO> getBoardList() {
		String SQL = "select * from board order by seq desc";
		return jdbc.query(SQL, new BoardRowMapper());
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		String SQL = "select * from board where seq=?";
		Object[] args = { vo.getSeq() };
		return jdbc.queryForObject(SQL, new BoardRowMapper(), args);
	}
}

class BoardRowMapper implements org.springframework.jdbc.core.RowMapper<BoardVO> {

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO m = null;
		m = new BoardVO();
		m.setSeq(rs.getInt("seq"));
		m.setTitle(rs.getString("title"));
		m.setWriter(rs.getString("writer"));
		m.setContent(rs.getString("content"));
		m.setRegdate(rs.getDate("regdate"));
		m.setCnt(rs.getInt("cnt"));
		return m;
	}
};