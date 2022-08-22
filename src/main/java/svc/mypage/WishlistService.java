package svc.mypage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.WishlistDAO;
import vo.store.StoreDTO;

public class WishlistService {

	public List<StoreDTO> selectWishlist(String sId) {
		System.out.println("WishlistService");
		List<StoreDTO> list = null;
		
		Connection con = getConnection();
		WishlistDAO dao = WishlistDAO.getInstance();
		dao.setCon(con);
		
		list = dao.selectWishlist(sId);
		
		close(con);
		
		return list;
	}

}
