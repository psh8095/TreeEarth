package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import vo.store.StoreDTO;
import vo.store.StoreReviewDTO;

public class StoreReviewListService {

	// 전체 구매 후기 갯수 조회 작업을 요청할 getStoreReviewListCount() 메서드 정의 
	public int getStoreReviewListCount(int sto_idx) {
		
		int storeReviewListCount  = 0;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// 전체 구매 후기 조회
		storeReviewListCount = dao.selectStoreReviewListCount(sto_idx);
		System.out.println("storeReviewListCount : " + storeReviewListCount);
		
		close(con);
		
		return storeReviewListCount;
	}

	// 전체 구매 후기 목록 조회 작업을 요청할 getStoreReviewList() 메서드 정의
	public ArrayList<StoreReviewDTO> getStoreReviewList(int pageNum, int listLimit, StoreDTO store) {
		
		ArrayList<StoreReviewDTO> storeReviewList = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		storeReviewList = dao.selectStoreReviewList(pageNum, listLimit, store);
		System.out.println("storeReviewList"); // 확인용
		
		close(con);
		
		return storeReviewList;
	}
	
}











