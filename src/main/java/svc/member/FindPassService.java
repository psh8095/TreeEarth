package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;
import vo.member.MemberDTO;

public class FindPassService {

	public String searchMemberPass(String mem_id, String mem_email) {
		System.out.println("FindPassService");
		
		String mem_pass = "";
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		MemberDTO member = dao.isMemberPass(mem_id, mem_email);
		
		mem_pass = member.getMem_pass();
		
		close(con);
		
		return mem_pass;
	}

}
