package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreQnaDTO;

public class StoreQnaDetailService {

	public StoreQnaDTO getStoreQnaDetail(int sto_qna_idx) {
		System.out.println("StoreQnaDetailService");
		
		StoreQnaDTO store_qna = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 문의글 1개 조회 작업
		store_qna = dao.selectStoreQnaDetail(sto_qna_idx);
		
		close(con);
		
		return store_qna;
	}

}
