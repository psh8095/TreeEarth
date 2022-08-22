package svc.mypage;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.WishlistDAO;

public class InsertWishlistService {

	public void insertWishlist(int sto_idx, String sId) {
		System.out.println("InsertWishlistService");
		Connection con = getConnection();
		WishlistDAO dao = WishlistDAO.getInstance();
		dao.setCon(con);
		
		boolean isInsert = dao.insertWishlist(sto_idx, sId);
		
		if(isInsert) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}

}
