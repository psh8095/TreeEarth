package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import vo.store.StoreDTO;

public class StoreListService {

	public int getListCount() {
		int listCount = 0;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 객체의 selectListCount() 메서드를 호출하여 전체 게시물 수 조회
		listCount = dao.selectItemListCount();
		
		close(con);
		
		return listCount;
	}

	public ArrayList<StoreDTO> getBoardList(int pageNum, int listLimit) {

		ArrayList<StoreDTO> articleList = null;
			
			Connection con = getConnection();
			StoreDAO dao = StoreDAO.getInstance();
			dao.setConnection(con);
			
			// StoreDAO 객체의 selectStoreList() 메서드를 호출하여 게시물 목록 조회
			// => 파라미터 : 현재 페이지 번호(pageNum), 페이지 당 게시물 수(listLimit)
			//    리턴타입 : ArrayList<StoreDTO> articleList
			articleList = dao.selectStoreList(pageNum, listLimit);
			
			close(con);
			
			return articleList;
		}

	}
