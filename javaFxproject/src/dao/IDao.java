package dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao<V,K> {
	public boolean insert(V vo) throws SQLException;	//회원가입,메인
	public boolean select(K key) throws SQLException;		//로그인,메인(검색?)
	public List<V> selectAll() throws SQLException;	//메인
	public boolean update(V vo) throws SQLException;	//메인
	public boolean delete(K key) throws SQLException;	//메인
}