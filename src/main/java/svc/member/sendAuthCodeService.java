package svc.member;


import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;

public class sendAuthCodeService {

	public boolean sendAuthCode(String email, String authCode) {
		System.out.println("4. 이메일 서비스");
		boolean isRegistSuccess = false;

		
		// ---------------------------------------------------------------------------------

		
		//DAO 3총사 
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);	

		
		// ---------------------------------------------------------------------------------

		
		//dao 메서드 호출, 리턴값 저장
		int registCount = dao.registAuthCode(email, authCode);
		
		
		//리턴값 판별
		if(registCount == 1) {
			System.out.println("6. DAO 리턴");
			isRegistSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		close(con);		
		
		
		return isRegistSuccess;
	}

}
