package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//TODO jdbc 1,2단계를 거쳐 Connection 객체를 만들어주는 공장 클래스
//ConnFactory.getConnection();
public class ConnFactory {
	public static Connection getConnection() {
		Connection conn = null;
		//(2) 데이터베이스 연결자 만들기 - url,user,password
			try {	// 1,2단계 통합
				Class.forName("oracle.jdbc.driver.OracleDriver");	//1단계
				String url = "jdbc:oracle:thin:@localhost:1521";	//2단계
				String user = "vsc06";
				String password = "java";
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException | ClassNotFoundException e) {
				System.err.println("Connection객체 생성 실패했습니다!");
			}
		return conn;
	}
}
