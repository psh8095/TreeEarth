package svc.community;

import java.sql.Connection;

import dao.FreeBoardDAO;
import db.JdbcUtil;
import vo.FreeboardDTO;

public class FreeBoardWriteProService {

	public boolean registFreeBoard(FreeboardDTO board) {
		boolean isWriteSuccess = false; // 글쓰기 작업요청 결과판별하여 리턴하기위한 boolean 타입 변수 선언
	
		Connection con = JdbcUtil.getConnection();
		
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		
		dao.setConnection(con);
		
		int insertCount = dao.insertFreeBoard(board);
		
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
