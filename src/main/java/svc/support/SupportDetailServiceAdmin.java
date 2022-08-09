package svc.support;

import vo.support.SupportDTO;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.SupportDAO;


public class SupportDetailServiceAdmin {
	
	
	//조회수 증가 메서드
	public void increaseReadCount(int sup_idx) {
		
	}

	public SupportDTO getBoard(int sup_idx) {
		System.out.println("4. getBoard 서비스");
		SupportDTO dto = null;
		
		
	// ----------------------------------------------------------------------------------------
		
		// 커넥션, dao 세팅	
		Connection con = getConnection();
		SupportDAO dao = SupportDAO.getInstance();
		dao.setConnection(con);
		
		
	// ----------------------------------------------------------------------------------------

		
		//dao 메서드 호출, 데이터 가져오기
		dto = dao.selectBoard(sup_idx);
		
		close(con);
		
		
		System.out.println("6. DAO 리턴");
		return dto;
	}

}
