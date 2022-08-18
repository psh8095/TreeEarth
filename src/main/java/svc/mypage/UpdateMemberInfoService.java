package svc.mypage;

import vo.member.MemberDTO;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class UpdateMemberInfoService {

	public void updateMemberInfo(String sId, MemberDTO member) {
		System.out.println("UpdateMemberInfoService");
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		int updateCount = dao.updateMemberInfo(sId, member);
		
		if(updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
	}

}
