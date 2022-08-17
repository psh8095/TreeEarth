package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.StoreDAO;
import vo.store.StoreQnaDTO;

public class StoreQnaWriteProService {

	public boolean getStoreQna(StoreQnaDTO storeQna) {
		
		boolean isWriteQnaSuccess = false;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		int insertQnaCount = dao.insertStoreQna(storeQna);
		
		if(insertQnaCount > 0) { // 후기 작성 성공할 경우
			commit(con);
			isWriteQnaSuccess = true;
		} else { // 실패할 경우
			rollback(con);
		}
		 
		close(con);
		
		return isWriteQnaSuccess;
	}
	
}
