package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class QnaWriteProService {

	public boolean registQna(QnaDTO qna) {
		System.out.println("QnaWriteProService - registQna");
		
		boolean isWriteSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		QnaDAO dao = QnaDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertQna(qna);
		
		if(insertCount > 0) {
			commit(con);
			isWriteSuccess = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return isWriteSuccess;
	}

}
