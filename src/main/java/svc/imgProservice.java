package svc;

import java.sql.Connection;

import dao.imgDAO;
import db.JdbcUtil;
import vo.ImgDTO;

public class imgProservice {

	public boolean registBoard(ImgDTO dto) {
		System.out.println("4 - sevice");
		boolean isWriteSuccess = false;
		
		
		//dao 기본 삼총사
		Connection con = JdbcUtil.getConnection();
		imgDAO dao = imgDAO.getInstance();
		dao.setConnection(con);
		
		
		//dao호출
		int insertCount = dao.insertBoard(dto);
		
		
		// ----------------------------------------------------------------------------------------

		//insert의 성공 판별 코드
		if(insertCount > 0) { 
			System.out.println("6 - insert성공 돌아가는 즁");
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else { 
			JdbcUtil.rollback(con);
		}
		
		
		return isWriteSuccess;
	}

}
