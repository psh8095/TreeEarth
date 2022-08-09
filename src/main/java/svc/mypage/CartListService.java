package svc.mypage;

import java.sql.Connection;
import java.util.List;

import dao.CartDAO;
import vo.store.StoreDTO;
import static db.JdbcUtil.*;

public class CartListService {

	public List<StoreDTO> selectCartList(String sId) {
		System.out.println("CartListService");
		List<StoreDTO> list = null;
		
		Connection con = getConnection();
		CartDAO dao = CartDAO.getInstance();
		dao.setCon(con);
		
		list = dao.selectCartList(sId);
		
		close(con);
		
		return list;
	}

}
