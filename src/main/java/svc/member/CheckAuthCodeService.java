package svc.member;

import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;

import java.sql.Connection;

import dao.MemberDAO;
import vo.member.AuthDTO;

import java.sql.Connection;


public class CheckAuthCodeService {

	public int checkAuthCode(AuthDTO dto) {
		System.out.println("4. 코드 서비스");
		int checkAuthCode = 0;
		
		
		// ---------------------------------------------------------------------------------

		//DAO 3총사 
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);	
		
		
		// ---------------------------------------------------------------------------------

		
		//dao 메서드 호출, 리턴값 저장
		checkAuthCode = dao.checkAuthCode(dto);
		
		
		System.out.println("6. DAO 리턴");
		//리턴값 판별
		if(checkAuthCode == 1) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return checkAuthCode;
	}

}
