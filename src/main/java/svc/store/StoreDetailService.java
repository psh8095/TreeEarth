package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreDTO;

public class StoreDetailService {

	public StoreDTO getStore(int order_id) {
		StoreDTO store = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		store = dao.selectStore(order_id);
		
		close(con);
		
		return store;
	}

}
