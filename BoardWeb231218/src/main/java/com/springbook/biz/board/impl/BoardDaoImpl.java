package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

// @Repository("boardDao")
public class BoardDaoImpl implements BoardDao {
	public BoardDaoImpl() {
		System.out.println("==> BoardDaoImpl 객체 생성");
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
	String select_sql = "select * from board order by seq";
	String select1_sql = "select * from board where seq=?";
	String delete_sql = "delete from board where seq=(select min(seq) as seq from board)";
	String delete1_sql = "delete from board where seq=?";
	String update_sql = "update board set title=?, writer=?, content=? where seq=?";
	
	@Override
	public void insert(BoardVO vo) {
		System.out.println("[로그확인] DaoImpl insert 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeLargeUpdate();
			System.out.println("저장완료");
		} catch (SQLException e) {
			System.out.println("저장실패");
			e.printStackTrace();
		} finally {
			System.out.println("insert finally");
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
		System.out.println("[로그확인] DaoImpl getBoardList 실행");
		List<BoardVO> li = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(select_sql);
			rs = pstmt.executeQuery();
			int recordCount = 0;
			
			BoardVO vo = null;
			while(rs.next()) {
				recordCount++;
				vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regDate"));
				vo.setCnt(rs.getInt("cnt"));
				li.add(vo);
				if(recordCount >= 8) {
					delete();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("getBoardList finally");
			JDBCUtil.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public void delete() {
		System.out.println("[로그확인] DaoImpl delete 실행");
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.executeLargeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		} finally {
			System.out.println("delete finally");
			JDBCUtil.close(pstmt, conn);
		}		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("[로그확인] DaoImpl getBoard 실행");
		BoardVO m = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(select1_sql);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new BoardVO();
				m.setSeq(rs.getInt("seq"));
				m.setTitle(rs.getString("title"));
				m.setWriter(rs.getString("writer"));
				m.setContent(rs.getString("content"));
				m.setRegdate(rs.getString("regDate"));
				m.setCnt(rs.getInt("cnt"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("getBoard finally");
			JDBCUtil.close(rs, pstmt, conn);
		}
		return m;
	}

	@Override
	public void delete(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(delete1_sql);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		} finally {
			System.out.println("delete finally");
			JDBCUtil.close(pstmt, conn);
		}	
	}

	@Override
	public void update(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(update_sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getSeq());
			pstmt.executeUpdate();
			
			System.out.println("수정완료");
		} catch (SQLException e) {
			System.out.println("수정실패");
			e.printStackTrace();
		} finally {
			System.out.println("update finally");
			JDBCUtil.close(pstmt, conn);
		}
	}

}
