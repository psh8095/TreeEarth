package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;

import dao.*;

public class FindPassAuthService {

	public boolean isMemberEmail(String mem_id, String mem_email) {
		System.out.println("FindPassAuthService");
		
		boolean isMemberEmail = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isMemberEmail = dao.isMemberEmail(mem_id, mem_email);
		
		close(con);
		
		return isMemberEmail;
	}
	
}
