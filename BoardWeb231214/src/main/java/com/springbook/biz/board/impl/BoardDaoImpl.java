package com.springbook.biz.board.impl;

import java.sql.*;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardDao;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

@Repository("boardDao") // component-scan 을 통해 객체 생성
public class BoardDaoImpl implements BoardDao {
	Connection conn = null;
	PreparedStatement pstmt = null;

	String insert_sql = "insert into board (seq, title, writer, content) values (?,?,?,?)";
	
	@Override
	public void insert(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setInt(1, vo.getSeq());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getWriter());
			pstmt.setString(4, vo.getContent());
			pstmt.executeLargeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}

	
}
