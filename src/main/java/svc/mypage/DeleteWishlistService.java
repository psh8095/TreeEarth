package svc.mypage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.WishlistDAO;

public class DeleteWishlistService {
	
	public void deleteWishlist(int sto_idx, String sId) {
		System.out.println("DeleteWishlistService");
		
		Connection con = getConnection();
		WishlistDAO dao = WishlistDAO.getInstance();
		dao.setCon(con);
		
		boolean isDelete = dao.deleteWishlist(sto_idx, sId);
		
		if(isDelete) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
	}

	public void deleteWishlist(String sId) {
		System.out.println("DeleteWishlistService");
		
		Connection con = getConnection();
		WishlistDAO dao = WishlistDAO.getInstance();
		dao.setCon(con);
		
		boolean isDelete = dao.deleteWishlist(sId);
		
		if(isDelete) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}
}
