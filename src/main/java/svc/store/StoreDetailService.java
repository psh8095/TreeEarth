package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreDTO;

public class StoreDetailService {

	public void increaseReadcount(int board_num) {
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		dao.updateReadcount(board_num);
		
		commit(con);
		
		close(con);
	}

	public StoreDTO getStore(int board_num) {
		StoreDTO store = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		store = dao.selectStore(board_num);
		
		close(con);
		
		return store;
	}

}
