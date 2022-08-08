package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;

import dao.*;
import vo.member.*;

public class MemberLoginProService {

	public boolean loginMember(MemberDTO member) {
//		System.out.println("MemberLoginProService");
		boolean isLoginSuccess = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isLoginSuccess = dao.selectMember(member);
		
		close(con);
		
		return isLoginSuccess;
	}
	
	

}
