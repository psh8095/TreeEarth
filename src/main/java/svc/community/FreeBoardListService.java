package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.FreeBoardDAO;
import vo.community.FreeboardDTO;

public class FreeBoardListService {

		// 전체 게시물 갯수 조회
		public int getListCount() {
			int listCount = 0;
			
			Connection con = getConnection();
			FreeBoardDAO dao = FreeBoardDAO.getInstance();
			dao.setConnection(con);
			
			listCount = dao.selectListCount();
			
			close(con);
			
			return listCount;
		}
	
		// 전체 게시물 목록 조회
		public ArrayList<FreeboardDTO> getBoardList(int pageNum, int listLimit) {
	
			ArrayList<FreeboardDTO> articleList = null;
			
			Connection con = getConnection();
			FreeBoardDAO dao = FreeBoardDAO.getInstance();
			dao.setConnection(con);
			
			articleList = dao.selectFreeBoardList(pageNum, listLimit);
			
			close(con);
			
			return articleList;
		}

}



