package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreDTO;

public class StoreItemDetailService {
	// 1개 상품 목록 상세 정보 조회
	public StoreDTO getItemDetail(int sto_idx) {
		
		StoreDTO store = null; 
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		store = dao.selectItemDetail(sto_idx);
		
		close(con);
		
		return store;
	}
	
}
