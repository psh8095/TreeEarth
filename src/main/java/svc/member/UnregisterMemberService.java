package svc.member;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class UnregisterMemberService {

	public void deleteMember(String sId) {
		System.out.println("UnregisterMemberService");
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		int deleteCount = dao.deleteMember(sId);
		
		if(deleteCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}

}
