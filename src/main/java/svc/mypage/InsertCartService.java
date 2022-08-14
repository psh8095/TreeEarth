package svc.mypage;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CartDAO;

public class InsertCartService {

	public void insertCart(int sto_idx, String sId) {
		System.out.println("InsertCartService");
		
		Connection con = getConnection();
		CartDAO dao = CartDAO.getInstance();
		dao.setCon(con);
		
		boolean isInsert = dao.insertCart(sto_idx, sId);
		
		if(isInsert) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}
	
}
