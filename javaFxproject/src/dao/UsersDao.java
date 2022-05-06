package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.ConnFactory;
import dto.Users;

public class UsersDao implements IDao<Users,String>{

	@Override
	public boolean insert(Users vo) throws SQLException {	//회원가입
		Connection conn = ConnFactory.getConnection();
		String sql = "INSERT INTO USERS(ID,PW,BIRTHDAY,PHONE,EMAIL) VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPw());
		pstmt.setDate(3, vo.getBirthday());
		pstmt.setString(4, vo.getPhone());
		pstmt.setString(5, vo.getEmail());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
	}

	@Override
	public boolean select(String key) throws SQLException {	//로그인
		boolean check = false;
		ResultSet rs = null;
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM USERS WHERE ID = ? AND PW = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, key);
		pstmt.setString(2, key);
		rs = pstmt.executeQuery();
		check = rs.next();
		
		pstmt.close();
		conn.close();
		return check;
	}
	
	public int login(String userID, String userPW) {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT PW FROM USERS WHERE ID = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pw").equals(userPW)) {
					return 1;	//로그인성공
				} else {
					return 0; //비밀번호 불일치
				}
			}
			return -1; //아이디가 없음
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return -2;	//DB오류
	}
	
//-----------------------------------------------------------------------------
	@Override
	public List<Users> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean update(Users vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(String key) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
