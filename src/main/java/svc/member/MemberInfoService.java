package svc.member;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;

import vo.member.MemberDTO;

public class MemberInfoService {

	public MemberDTO getMemberInfo(String sId) {
		System.out.println("MemberInfoService");
		MemberDTO member = null;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		member = dao.selectMemberInfo(sId);
		
		close(con);
		
		return member;
	}

}
