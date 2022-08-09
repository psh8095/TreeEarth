package svc.member;

import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.MemberDAO;

public class CheckIdService {

	public int checkId(String id) {
		System.out.println("4. 아이디 서비스");
		int checkId = 0;
		
		
		// ---------------------------------------------------------------------------------

		//DAO 3총사 
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);	
				
				
		// ---------------------------------------------------------------------------------

				
		//dao 메서드 호출, 리턴값 저장
		checkId = dao.checkId(id);
				
		
		return checkId;
	}

}
