package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreDTO;

public class StoreDetailService {

	public StoreDTO getStore(int sto_idx) {
		StoreDTO store = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		store = dao.selectStore(sto_idx);
		
		close(con);
		
		return store;
	}

}
