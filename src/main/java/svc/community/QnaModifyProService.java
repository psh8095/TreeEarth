package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class QnaModifyProService {

	//수정 작업 요청
	public boolean modifyQna(QnaDTO qna) {
		
		boolean modifyQna = false;
		
		//싱글톤 디자인 패턴으로 생성된 QnaDAO 인스턴스 활용
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		//답변
		int updateCount = dao.updateQna(qna);
		
		if(updateCount > 0) {
			commit(con);
			modifyQna = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return modifyQna;
	}

}
