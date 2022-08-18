package svc.mypage;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class CheckPassService {

	public boolean checkPass(String sId, String mem_pass) {
		System.out.println("CheckPassService");
		boolean isPass = false;
		
		Connection con = getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		isPass = dao.checkPass(sId, mem_pass);
		
		close(con);
		
		return isPass;
	}

}
