package svc;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.util.ArrayList;

import dao.imgDAO;
import db.JdbcUtil;
import vo.ImgDTO;

public class ImgListService {

	public static ArrayList<ImgDTO> getBoardList() {
		System.out.println("4 - sevice");
		ArrayList<ImgDTO> articleList = null;
		
		
		//dao 기본 삼총사
		Connection con = JdbcUtil.getConnection();
		imgDAO dao = imgDAO.getInstance();
		dao.setConnection(con);
		
		
		// ----------------------------------------------------------------------------------------
		articleList = dao.selectBoardList();
		
		close(con);
		
		System.out.println("6 - sevice 집에가나?");
		return articleList;
	}

}
