package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.CampaignReviewDAO;
import dao.FaqDAO;
import db.JdbcUtil;

public class QnaFaqDeleteProService {

	public boolean isQnaFaqWriter(int faq_idx, String mem_pass) {
		System.out.println("QnaFaqDeleteProService - isQnaFaqWriter");
		
		boolean isQnaFaqWriter = false;
		
		//싱글톤 디자인 패턴으로 생성된 FaqDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		FaqDAO dao = FaqDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 권한 판별 요청
		isQnaFaqWriter = dao.isQnaFaqWriter(faq_idx, mem_pass);
		
		close(con);
		
		return isQnaFaqWriter;
	}

	public boolean deleteQnaFaq(int faq_idx) {
		
		boolean isDeleteSuccess = false;
		
		//싱글톤 디자인 패턴으로 생성된 FaqDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		FaqDAO dao = FaqDAO.getInstance();
		dao.setConnection(con);
		
		//삭제 요청
		int deleteCount = dao.deleteQnaFaq(faq_idx);
		
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
