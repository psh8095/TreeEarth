package svc.store;

import java.sql.Connection;

import dao.StoreDAO;
import db.JdbcUtil;
import vo.store.StoreDTO;

public class StoreWriteProService {

	public boolean registStore(StoreDTO store) {
		boolean isWriteSuccess = false; // 상품 등록 작업요청 결과판별하여 리턴하기위한 boolean 타입 변수 선언
		
		Connection con = JdbcUtil.getConnection();
		
		StoreDAO dao = StoreDAO.getInstance();
		
		dao.setConnection(con);
		
		int insertCount = dao.insertStore(store);
		
		if(insertCount > 0) {	// 작업 성공 시
			JdbcUtil.commit(con);
			isWriteSuccess = true; // 작업 처리 결과 성공으로 표시하기 위해 true 로 변경
		} else {	// 작업 실패 시
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		
		return isWriteSuccess;
	}

}