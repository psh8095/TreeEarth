package dao;

import java.sql.Connection;

public class CartDAO {
	// --- 싱글톤 패턴 구현 ---
	private static CartDAO instance = new CartDAO();
	
	private CartDAO() {}
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	private Connection con;

	public void setCon(Connection con) {
		this.con = con;
	}
	// --- 싱글톤 패턴 구현 ---
	
}
