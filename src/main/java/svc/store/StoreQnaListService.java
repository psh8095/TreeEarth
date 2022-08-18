package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import vo.store.StoreDTO;
import vo.store.StoreQnaDTO;

public class StoreQnaListService {

	public int getStoreQnaListCount() {
		
		int storeQnaListCount = 0;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 전체 문의글 조회
		storeQnaListCount = dao.selectStoreQnaListCount();
		System.out.println("storeQnaListCount : " + storeQnaListCount);
		
		close(con);
		
		return storeQnaListCount;
	}
	
	// 전체 문의글 목록 조회 작업을 요청할 getStoreQnaList() 메서드 정의
	public ArrayList<StoreQnaDTO> getStoreQnaList(int pageNum, int listLimit, StoreDTO store) {
		
		ArrayList<StoreQnaDTO> storeQnaList = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		storeQnaList = dao.selectStoreQnaList(pageNum, listLimit, store);
		System.out.println(storeQnaList); // 확인용
		
		close(con);
		
		return storeQnaList;
	}

}
















