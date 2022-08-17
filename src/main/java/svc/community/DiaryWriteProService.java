package svc.community;

import java.sql.*;

import dao.*;
import vo.community.*;

import static db.JdbcUtil.*;

public class DiaryWriteProService {
	
	public boolean registBoard(DiaryDTO diary) {
		System.out.println("4.DiaryWriteProService");
		boolean isWriteSuccess = false;
	
	Connection con = getConnection();
	DiaryDAO dao = DiaryDAO.getInstance();
	dao.setConnection(con);
	
	int insertCount = dao.insertDiary(diary);
	
	if(insertCount > 0) {
		System.out.println("6. DAO 반환 성공");
		commit(con);
		isWriteSuccess = true;
	}else{
		rollback(con);
	}
	close(con);
	
	return isWriteSuccess;
	
	}

}
