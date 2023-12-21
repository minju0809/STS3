package com.springbook.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public BoardDaoImpl() {
		System.out.println("@@@@@@@@@@@@@==> BoardDaoSpring 객체 생성");
	}

	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
	String select_sql = "select * from board order by seq";
	String select1_sql = "select * from board where seq=?";
	String delete_sql = "delete from board where seq=(select min(seq) as seq from board)";
	String delete1_sql = "delete from board where seq=?";
	String update_sql = "update board set title=?, writer=?, content=? where seq=?";

	@Override
	public void insert(BoardVO vo) {
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(insert_sql, args);
	}
	
	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		
		return jdbcTemplate.query(select_sql, new BoardRowMapper());
	}
	
//	@Override
//	public BoardVO getBoard(BoardVO vo) {
//		Object[] args = { vo.getSeq() };
//		return jdbcTemplate.queryForObject(select1_sql, new BoardRowMapper(), args);
//	}
	
	
//	@Override
//	public void delete(BoardVO vo) {
//		Object[] args = { vo.getSeq() };
//		jdbcTemplate.update(delete1_sql, new BoardRowMapper(), args);
//	}

}

