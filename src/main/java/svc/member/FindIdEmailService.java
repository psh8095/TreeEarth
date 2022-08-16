package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;

import dao.*;
import vo.member.*;

public class FindIdEmailService {

	public String searchMemberId(String mem_name, String mem_email) {
		System.out.println("FindIdService");

		String mem_id = null;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		MemberDTO member = dao.isMemberIdEmail(mem_name, mem_email);
		
		mem_id = member.getMem_id();
		
		close(con);
		
		return mem_id;
	}

}
