package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.rollback;

import java.sql.*;

import dao.*;
import db.*;
import vo.community.*;

public class QnaFaqWriteProService {

	public boolean registFaq(QnaFaqDTO qnafaq) {
		System.out.println("QnaFaqWriteProService - registFaq");
		
		boolean isWriteSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		FaqDAO dao = FaqDAO.getInstance();
		dao.setConnection(con);
		
		int insertCount = dao.insertFaq(qnafaq);
		
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
