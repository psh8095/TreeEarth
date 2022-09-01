package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.FreeBoardDAO;
import vo.community.FreeboardDTO;

public class FreeBoardModifyProService {

	// 수정 권한 판별
	public boolean isFreeBoardWriter(int free_idx, String free_pass) {
		boolean isFreeBoardWriter = false;
		
		Connection con = getConnection();
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.setConnection(con);
		
		// FreeBoardDAO 객체의 isFreeBoardWriter() 메서드를 호출하여 수정 권한 판별 수행
		isFreeBoardWriter = dao.isFreeBoardWriter(free_idx, free_pass);
		
		close(con);
		
		return isFreeBoardWriter;
	}
	
	// 글 수정 작업 요청
	public boolean modifyFreeBoard(FreeboardDTO board) {
		boolean isModifySuccess = false;
		
		Connection con = getConnection();
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.setConnection(con);
		
		// FreeBoardDAO 의 updateFreeBoard() 메서드를 호출하여 글 수정 작업 수행
		int updateCount = dao.updateFreeBoard(board);
		
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