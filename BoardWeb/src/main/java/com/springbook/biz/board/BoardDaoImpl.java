package com.springbook.biz.board;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.conn.DBConnection;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private DBConnection dbConnection = null;
	private Connection conn = null;
	private String SQL = "";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

//	public BoardDaoImpl() {
//		dbConnection = DBConnection.getInstance();
//	}

	@Override
	public void insert(BoardVO vo) {
		try {
			conn = dbConnection.getConnection();
			SQL = "insert into board (seq, title, writer, content) values (?,?,?,?)";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, vo.getSeq());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(BoardVO vo) {
		try {
			conn = dbConnection.getConnection();
			SQL = "update board set title=?, writer=?, content=? where seq=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int k) {
		try {
			conn = dbConnection.getConnection();
			SQL = "delete from board where seq=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, k);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BoardVO getBoard(int k) {
		BoardVO vo = null;
		try {
			conn = dbConnection.getConnection();
			SQL = "select * from board where seq=?";
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, k);
			rs = pstmt.executeQuery();
			rs.next();
			vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setRegDate(rs.getDate("regdate"));
			vo.setCnt(rs.getInt("cnt"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> li = new ArrayList<BoardVO>();
		try {
			conn = dbConnection.getConnection();
			SQL = "select * from board order by seq desc";
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			BoardVO vo = null;

			while (rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				li.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<BoardVO> getBoardList(String ch1, String ch2) {
		System.out.println("ch1 : " + ch1 + ", ch2 : " + ch2);
		
		List<BoardVO> li = new ArrayList<BoardVO>();
		try {
			conn = dbConnection.getConnection();
			if (ch1 == null || ch2 == null || ch2 == "") {				
				SQL = "select * from board order by seq desc";
				pstmt = conn.prepareStatement(SQL);
			} else if (ch1.equals("title")) {
				SQL = "select * from board where title like ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + ch2 + "%");
			} else if (ch1.equals("writer")) {
				SQL = "select * from board where writer like ?";
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, "%" + ch2 + "%");
			}
			rs = pstmt.executeQuery();

			BoardVO vo = null;

			while (rs.next()) {
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegDate(rs.getDate("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				li.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return li;
	}

}
