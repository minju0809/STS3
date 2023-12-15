package com.springbook.biz.board.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//@Repository("boardDao") // component-scan 을 통해 객체 생성
public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String insert_sql = "insert into board (seq, title, writer, content) "
			+ " values ((select max(seq)+1 as seq from board),?,?,?)";
	String select_sql = "select * from board order by seq";
	String delete_sql = "delete from board where seq=(select min(seq) as seq from board)";
	String count_sql = "select count(*) as count from board";
	
	@Override
	public void insert(BoardVO vo) {
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
			JDBCUtil.close(pstmt, conn);
		}
	}

	@Override
	public List<BoardVO> getBoardList() {
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
				vo.setCnt(rs.getInt("cnt"));
				li.add(vo);
				if(recordCount >= 8) {
					delete();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return li;
	}

	@Override
	public void delete() {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(delete_sql);
			pstmt.executeLargeUpdate();
			System.out.println("삭제완료");
		} catch (SQLException e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}		
	}

	@Override
	public int count() {
		int count = 0;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(count_sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return count;
	}

	
}
