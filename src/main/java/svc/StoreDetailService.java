package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.StoreDAO;
import vo.StoreDTO;

public class StoreDetailService {
	
	// 조회수 증가 작업을 요청하는 increaseReadcount() 메서드
	public void increaseReadcount(int sto_idx) {
		Connection con = getConnection();
		
		StoreDAO dao = StoreDAO.getInstance();
		
		dao.setConnection(con);
		
		// BoardDAO 객체의 updateReadcount() 메서드를 호출하여 조회수 증가 작업 수행
		// => 파라미터 : board_num
		dao.updateReadcount(sto_idx);
		
		// 조회수 증가 작업 commit
		commit(con);
		
		close(con);
	}
		

	// 1개 게시물 상세 정보 조회 작업을 요청하는 getStore() 메서드
	public StoreDTO getStore(int sto_idx) {
		StoreDTO store = null;
		
		Connection con = getConnection();
		
		StoreDAO dao = StoreDAO.getInstance();
		
		dao.setConnection(con);
		
		// BoardDAO 객체의 selectBoard() 메서드를 호출하여 1개 게시물의 상세 정보 조회 작업 수행
		// => 파라미터 : board_num   리턴타입 : BoardDTO(board)
		store = dao.selectBoard(sto_idx);
		
		close(con);
		
		return store;
	}

}
