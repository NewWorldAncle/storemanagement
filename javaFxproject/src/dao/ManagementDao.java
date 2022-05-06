package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnFactory;
import dto.Management;

public class ManagementDao implements IDao2<Management, Integer>{

	@Override
	public boolean insert(Management vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "INSERT INTO MANAGEMENT(ID,MENT_NUM,MENT_GOODS,MENT_DATE,MENT_INVEN) "
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setInt(2, vo.getMent_num());
		pstmt.setString(3, vo.getMent_goods());
		pstmt.setDate(4, vo.getMent_date());
		pstmt.setInt(5, vo.getMent_inven());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
	}

	@Override
	public Management select(String key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM MANAGEMENT WHERE MENT_GOODS = ?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, key);
		ResultSet rs = pstmt.executeQuery();
		Management vo = new Management();
		while(rs.next()) {
			vo.setId(rs.getString("id"));
			vo.setMent_num(rs.getInt("ment_num"));
			vo.setMent_goods(rs.getString("ment_goods"));
			vo.setMent_date(rs.getDate("ment_date"));
			vo.setMent_inven(rs.getInt("ment_inven"));
		}
		pstmt.close();
		conn.close();
		return vo;
	}

	@Override
	public List<Management> selectAll() throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM MANAGEMENT";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Management> list = new ArrayList<>();
		while(rs.next()) {
			Management vo = new Management();
			vo.setId(rs.getString("id"));
			vo.setMent_num(rs.getInt("ment_num"));
			vo.setMent_goods(rs.getString("ment_goods"));
			vo.setMent_date(rs.getDate("ment_date"));
			vo.setMent_inven(rs.getInt("ment_inven"));
			list.add(vo);
		}
		pstmt.close();
		conn.close();
		return list;
	}
	
	@Override
	public boolean update(Management vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "UPDATE MANAGEMENT SET ID=?,MENT_GOODS=?,MENT_DATE=?,MENT_INVEN=? "
				+ "WHERE MENT_NUM=?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getMent_goods());
		pstmt.setDate(3, vo.getMent_date());
		pstmt.setInt(4, vo.getMent_inven());
		pstmt.setInt(5, vo.getMent_num());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
	}

	@Override
	public int delete(Integer key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM MANGEMENT WHERE MENT_NUM = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, key);
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return res;
	}

	@Override
	public Management select(Integer key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
