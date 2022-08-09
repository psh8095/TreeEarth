package svc.member;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import vo.member.MemberDTO;

public class JoinProService {

	public boolean joinMember(MemberDTO dto) {
		System.out.println("4. 서비스");
		boolean isJoinSuccess = false;
		
		
		// ----------------------------------------------------------------------------------------
		
		// 커넥션, dao 세팅
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		
		// ----------------------------------------------------------------------------------------

		
		//dao 메서드 호출, 리턴값 저장
		int insertCount = dao.insertMember(dto);

		
		//리턴값 판별
		if(insertCount > 0) {
			System.out.println("6. DAO 리턴");
			commit(con);
			isJoinSuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		
		// ----------------------------------------------------------------------------------------

		
		return isJoinSuccess;		
	}

}
