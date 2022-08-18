package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;

public class QnaDeleteProService {

	public boolean isQnaWriter(int qna_idx, String mem_pass) {
		System.out.println("QnaDeleteProService - isWriter");
		
		boolean isQnaWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 FaqDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 권한 판별 요청
		isQnaWriter = dao.isQnaWriter(qna_idx, mem_pass);
		
		close(con);
		
		return isQnaWriter;
	}

	public boolean deleteQna(int qna_idx) {
		
		boolean isDeleteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 FaqDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 요청
		int deleteCount = dao.deleteQna(qna_idx);
		
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isDeleteSuccess;
	}

}
