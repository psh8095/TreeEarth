package svc.mypage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.MemberDAO;
import vo.member.MemberDTO;

public class MemberListService {

	public List<MemberDTO> getMemberList() {
		System.out.println("MemberListService");
		List<MemberDTO> memberList = null;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		memberList = dao.selectMemberList();
		
		close(con);
		
		return memberList;
	}

}
