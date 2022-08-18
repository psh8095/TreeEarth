package svc.support;

import static db.JdbcUtil.*;

import java.sql.*;

import dao.*;
import vo.support.SupportDTO;

public class MoneyCheckProService {

	//선택한 금액이 반영되었는지 확인 위한 checkMoney() 정의
	public boolean checkMoney(SupportDTO dto) {
		System.out.println("4.checkMoney");
		
		boolean isCorrectMoney = false;
		
		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);
		
	// ----------------------------------------------------------------------------------------

		int updateCount = dao.updateMoney(dto);
		System.out.println(updateCount);
		
	// ----------------------------------------------------------------------------------------
	
		
		if(updateCount > 0) {
			System.out.println("6.후원금 확인");
			commit(con);
			isCorrectMoney = true;
		}else {
			System.out.println("6.후원금 확인 실패");
			rollback(con);
		}
		
		return isCorrectMoney;
	}
	

}
