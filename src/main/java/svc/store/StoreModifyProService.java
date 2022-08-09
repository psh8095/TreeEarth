package svc.store;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreDTO;
import static db.JdbcUtil.*;

public class StoreModifyProService {

	// 수정 권한 판별을 위한 isStoreWriter()
	public boolean isStoreWriter(int sto_idx) {
		boolean isStoreWriter = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 의 isStoreWriter() 메서드를 호출하여 수정 권한 판별 수행
		isStoreWriter = dao.isStoreWriter(sto_idx);
		
		close(con);
		
		return isStoreWriter;
	}

	// 수정 작업 요청을 위한 modifyStore()
	public boolean modifyStore(StoreDTO store) {
		boolean isModifySuccess = false;

		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 의 updateStore() 메서드를 호출하여 글 수정 작업 수행
		int updateCount = dao.updateStore(store);
		
		// 글 수정 작업 실행 결과 판별하여 성공 시 commit, 실패 시 rollback
		if(updateCount > 0) {
			commit(con);
			isModifySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
				
		return isModifySuccess;
	}

}
