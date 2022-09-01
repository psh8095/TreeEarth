package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.FreeBoardDAO;
import vo.community.FreeboardDTO;

public class FreeBoardReplyProService {
	
	// 답글 작성 요청 작업을 수행하는 replyBoard() 메서드
	public boolean replyBoard(FreeboardDTO board) {
		boolean isReplySuccess = false;
		
		Connection con = getConnection();
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.setConnection(con);
		
		// FreeBoardDAO 의 insertReplyBoard() 메서드 호출하여 답글 등록 작업 수행
		// => 파라미터 : BoardDTO 객체   리턴타입 : int(insertCount)
		int insertCount = dao.insertReplyBoard(board);
		
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