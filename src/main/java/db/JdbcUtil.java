package db;

import java.sql.*;

import javax.naming.*;
import javax.sql.*;

public class JdbcUtil {

	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			Context initCtx = new InitialContext();
			
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
			
			con = ds.getConnection();
			
			//트랜잭션 처리
			//commit, rollback 작업 수동으로 실행해야 함.
			con.setAutoCommit(false);
			
		} catch (NamingException e) {
			e.printStackTrace();
			System.out.println("getConnection() 오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getConnection() 오류");
		}
		
		return con;
		
	}
	
	public static void close(Connection con) {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(PreparedStatement pstmt) {
		
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(ResultSet rs) {
		
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("jdbcUtil - commit() 오류");
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("jdbcUtil - rollback() 오류");
		}
	}
	
}
