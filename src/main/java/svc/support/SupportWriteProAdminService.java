package svc.support;

import java.sql.*;
import static db.JdbcUtil.*;

import dao.*;
import vo.*;
import vo.support.SupportDTO;

public class SupportWriteProAdminService {

	public boolean registSupport(SupportDTO dto) {
		boolean isWritesuccess = false;
		Connection con = getConnection(); // 공통. serviece 클래스에 무조건 들어감

		SupportDAO dao = SupportDAO.getInstance();

		dao.setConnection(con);

		int insertCount = dao.insertSupportBoard(dto);

		if (insertCount > 0) {
			commit(con);
			isWritesuccess = true;
		} else {
			rollback(con);
		}

		close(con);
		// con은 참고변수값 전달->주소값
		return isWritesuccess;
	}

}
