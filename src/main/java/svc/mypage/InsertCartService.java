package svc.mypage;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CartDAO;

public class InsertCartService {

	public boolean insertCart(int sto_idx, String sId) {
		System.out.println("InsertCartService");
		boolean isCart = false;
		
		Connection con = getConnection();
		CartDAO dao = CartDAO.getInstance();
		dao.setCon(con);
		
		isCart = dao.insertCart(sto_idx, sId);
		
		if(isCart) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isCart;
	}
	
}
