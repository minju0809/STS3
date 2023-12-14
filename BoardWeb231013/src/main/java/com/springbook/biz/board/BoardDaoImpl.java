package com.springbook.biz.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private DBConnection DBConn;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = DBConn.getConnection();
			System.out.println("확인" + conn);
			String SQL = "insert into board (seq, title, writer, content) values (?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getSeq());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close1(pstmt, conn);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> li = new ArrayList<BoardVO>();
		try {
			conn = DBConn.getConnection();
			String SQL = "select * from board order by seq desc";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			BoardVO m = null;
			while (rs.next()) {
				m = new BoardVO();
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				m.setContent(rs.getString("content"));
				m.setRegdate(rs.getDate("regdate"));
				m.setCnt(rs.getInt("cnt"));
				li.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close1(pstmt, conn);
		}
		return li;
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = DBConn.getConnection();
			System.out.println("확인" + conn);
			String SQL = "delete from board where seq=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConn.close1(pstmt, conn);
		}
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return null;
	}
}
