package svc.community;

import java.sql.Connection;

import dao.CampaignReviewDAO;
import dao.QnaDAO;
import db.JdbcUtil;
import vo.community.QnaDTO;

import static db.JdbcUtil.*;

public class QnaModifyService {

	public QnaDTO getQna(int qna_idx) {
		
		QnaDTO qna = null;
		
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		//qna detail 가져오기(id, tag, subject, content)
		qna = dao.selectQnaDetail(qna_idx);
		
		close(con);
		
		return qna;
	}

}
