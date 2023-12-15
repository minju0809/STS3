package com.springbook.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.springbook.biz.common.JDBCUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String select_sql = "select * from users where id=? and password=?";
	
	
	
	@Override
	public UserVO getUser(UserVO vo) {
		UserVO m = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				m = new UserVO();
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setRole(rs.getString("role"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return m;
	}

}
