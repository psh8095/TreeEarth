package svc.support;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.*;
import vo.support.SupportDTO;

public class SupportListService {

	public ArrayList<SupportDTO> getSupportList() {
		System.out.println("4. SupportList서비스");
		ArrayList<SupportDTO> articleList = null;
		
		
		
	// ----------------------------------------------------------------------------------------
		
		// 커넥션, dao 세팅		
		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);
		
		
	// ----------------------------------------------------------------------------------------

		
		//dao 메서드 호출, 리스트 가져오기
		articleList = dao.selectSupportList();
		System.out.println("6. DAO 리턴");

		
		close(con);
		
		return articleList;
		
	}

}
