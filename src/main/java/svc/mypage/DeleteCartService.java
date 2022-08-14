package svc.mypage;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.CartDAO;

public class DeleteCartService {

	public void deleteCart(int sto_idx, String sId) {
		System.out.println("DeleteCartService");
		
		Connection con = getConnection();
		CartDAO dao = CartDAO.getInstance();
		dao.setCon(con);
		
		boolean isDelete = dao.deleteCart(sto_idx, sId);
		
		if(isDelete) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
	}

}
