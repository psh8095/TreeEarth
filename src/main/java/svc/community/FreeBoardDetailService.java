package svc.community;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.FreeBoardDAO;
import vo.community.FreeboardDTO;

	public class FreeBoardDetailService {

		// 조회수 증가 작업
		public void increaseReadcount(int free_idx) {
			
			Connection con = getConnection();
			FreeBoardDAO dao = FreeBoardDAO.getInstance();
			dao.setConnection(con);
			
			dao.updateReadcount(free_idx);
			
			commit(con);
			
			close(con);
		}
	
		// 게시물 상세 정보 조회 작업
		public FreeboardDTO getBoard(int free_idx) {
			FreeboardDTO freeboard = null;
			
			Connection con = getConnection();
			FreeBoardDAO dao = FreeBoardDAO.getInstance();
			dao.setConnection(con);
			
			// FreeBoardDAO 객체의 selectFreeBoardList() 메서드를 호출하여 1개 게시물의 상세 정보 조회 작업 수행
			freeboard = dao.selectFreeBoardList(free_idx);
			
			close(con);
			
			return freeboard;
		}

	}



