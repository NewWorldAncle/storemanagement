package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.ConnFactory;
import dto.Membership;

public class MembershipDao implements IDao2<Membership, Integer>{

	@Override
	public boolean insert(Membership vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "INSERT INTO MEMBERSHIP(ID,MEM_NUM,MEM_NAME,MEM_DATE,MEM_PHONE,MEM_ADDRESS) "
				+ "VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setInt(2, vo.getMem_num());
		pstmt.setString(3, vo.getMem_name());
		pstmt.setDate(4, vo.getMem_date());
		pstmt.setString(5, vo.getMem_phone());
		pstmt.setString(6, vo.getMem_address());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
	}

	@Override
	public Membership select(String key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM MEMBERSHIP WHERE MEM_NAME LIKE ?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, key);
		ResultSet rs = pstmt.executeQuery();
		Membership vo = new Membership();
		while(rs.next()) {
			vo.setId(rs.getString("id"));
			vo.setMem_num(rs.getInt("mem_num"));
			vo.setMem_name(rs.getString("mem_name"));
			vo.setMem_date(rs.getDate("mem_date"));
			vo.setMem_phone(rs.getString("mem_phone"));
			vo.setMem_address(rs.getString("mem_address"));
		}
		pstmt.close();
		conn.close();
		return vo;
	}

	@Override
	public List<Membership> selectAll() throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "SELECT * FROM MEMBERSHIP";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Membership> list = new ArrayList<>();
		while(rs.next()) {
			Membership vo = new Membership();
			vo.setId(rs.getString("id"));
			vo.setMem_num(rs.getInt("mem_num"));
			vo.setMem_name(rs.getString("mem_name"));
			vo.setMem_date(rs.getDate("mem_date"));
			vo.setMem_phone(rs.getString("mem_phone"));
			vo.setMem_address(rs.getString("mem_address"));
			list.add(vo);
		}
		pstmt.close();
		conn.close();
		return list;
	}

	@Override
	public boolean update(Membership vo) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "UPDATE MEMBERSHIP SET ID=?, MEM_NAME=?, MEM_DATE=?, "
				+ "MEM_PHONE=? , MEM_ADDRESS=? WHERE MEM_NUM=?";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getMem_name());
		pstmt.setDate(3, vo.getMem_date());
		pstmt.setString(4, vo.getMem_phone());
		pstmt.setString(5, vo.getMem_address());
		pstmt.setInt(6, vo.getMem_num());
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return (res>=1)?true:false;
	}

	@Override
	public int delete(Integer key) throws SQLException {
		Connection conn = ConnFactory.getConnection();
		String sql = "DELETE FROM MEMBERSHIP WHERE MEM_NUM = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, key);
		int res = pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		return res;
	}

	@Override
	public Membership select(Integer key) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
