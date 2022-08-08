package svc.support;

import java.sql.*;
import static db.JdbcUtil.*;

import dao.*;
import vo.*;
import vo.support.SupportDTO;

public class SupportWriteProAdminService {

	public boolean registSupport(SupportDTO dto) {
		System.out.println("4. SupportWrite서비스");
		boolean isWritesuccess = false;
		
		
	// ----------------------------------------------------------------------------------------
		
		// 커넥션, dao 세팅
		Connection con = getConnection(); // 공통. serviece 클래스에 무조건 들어감
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);
		
		
	// ----------------------------------------------------------------------------------------

		
		//dao 메서드 호출, 리턴값 저장
		int insertCount = dao.insertSupportBoard(dto);

		
		//리턴값 판별
		if (insertCount > 0) {
			System.out.println("6. DAO 리턴");
			commit(con);
			isWritesuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		
	// ----------------------------------------------------------------------------------------
	
		return isWritesuccess;
	}

}
