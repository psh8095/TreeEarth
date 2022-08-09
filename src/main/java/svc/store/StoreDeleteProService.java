package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.StoreDAO;

public class StoreDeleteProService {

	// 삭제 권한 판별 요청을 수행하는 isStoreWriter()
	public boolean isStoreWriter(int sto_idx) {
		boolean isStoreWriter = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 객체의 isStoreWriter() 메서드를 호출하여 삭제 권한 판별 수행
		isStoreWriter = dao.isStoreWriter(sto_idx);
		
		close(con);
		return isStoreWriter;
	}

	// 삭제 요청을 수행하는 removeStore()
	public boolean removeStore(int sto_idx) {
		boolean isDeleteSuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 객체의 deleteStore() 메서드를 호출하여 삭제 작업 수행
		// => 파라미터 : 글번호    리턴타입 : int(deleteCount)
		int deleteCount = dao.deleteStore(sto_idx);
		
		// deleteCount 가 0 보다 크면 commit, 아니면 rollback 작업 수행
		if(deleteCount > 0) {
			commit(con);
			// isDeleteSuccess 값을 true 로 변경하여 성공 표시
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}

}
