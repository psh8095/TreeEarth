package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.*;

import dao.*;
import vo.member.*;

public class FindIdService {

	public String searchMemberId(String mem_name, String mem_phone) {
		System.out.println("FindIdService");

		String mem_id = null;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		MemberDTO member = dao.isMemberId(mem_name, mem_phone);
		
		mem_id = member.getMem_id();
		
		close(con);
		
		return mem_id;
	}

}
