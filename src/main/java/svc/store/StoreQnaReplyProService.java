package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.QnaDAO;
import vo.store.StoreQnaDTO;

public class StoreQnaReplyProService {

	public boolean replyBoard(StoreQnaDTO store_qna) {
		boolean isReplySuccess = false;
		
		Connection con = getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		// QnaDAO 의 insertReplyQna() 메서드 호출하여 답글 등록 작업 수행
		// => 파라미터 : StoreQnaDTO 객체   리턴타입 : int(insertCount)
		int insertCount = dao.insertReplyQna(store_qna);
		
		if(insertCount > 0) {
			commit(con);
			isReplySuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isReplySuccess;
	}

}
