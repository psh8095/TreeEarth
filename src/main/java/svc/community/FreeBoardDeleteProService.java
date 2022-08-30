package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.FreeBoardDAO;



public class FreeBoardDeleteProService {

	// 삭제 권한 판별
	public boolean isFreeBoardWriter(int free_idx, String free_pass) {
		boolean isFreeBoardWriter = false;
		
		Connection con = getConnection();
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO 객체의 isBoardWriter() 메서드를 호출하여 삭제 권한 판별 수행
		isFreeBoardWriter = dao.isFreeBoardWriter(free_idx, free_pass);
		
		close(con);
		
		return isFreeBoardWriter;
	}
	
	// 삭제 요청 수행
	public boolean removeBoard(int free_idx) {
		boolean isDeleteSuccess = false;
		
		Connection con = getConnection();
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.setConnection(con);
		
		int deleteCount = dao.deleteBoard(free_idx);
		
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