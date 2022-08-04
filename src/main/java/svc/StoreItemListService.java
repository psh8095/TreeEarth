package svc;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import vo.StoreDTO;

import static db.JdbcUtil.*;

public class StoreItemListService {
	
	// 전체 상품 목록 갯수 조회 작업을 요청할 getItemListCount() 메서드
	public int getItemListCount() {
		
		int itemListCount = 0;
		
		// Connection 객체 가져오기
		Connection con = getConnection();
		// StoreDAO 객체 가져오기
		StoreDAO dao = StoreDAO.getInstance();
		// StoreDAO 객체에 Connection 객체 전달하기
		dao.setConnection(con);
		
		// StoreDAO 객체의 selectItemListCount() 메서드를 호출하여 전체 상품 목록 갯수 조회
		itemListCount = dao.selectItemListCount(); 

		close(con);

		return itemListCount;
	}
	
	// 전체 상품 목록 조회 작업을 요청할 getStoreItemList() 메서드 정의
	public ArrayList<StoreDTO> getStoreItemList(int pageNum, int listLimit) {
		
		ArrayList<StoreDTO> storeList = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// StoreDAO 객체의 selectStoreItemList() 메서드 호출하여 상품 목록 조회
		// 파라미터 : 현재 페이지 번호(pageNum), 페이지 당 상품 목록 수(listLimit)
		// 리턴타입 : ArrayList<StoreDTO>(storeList)
		storeList = dao.selectStoreItemList(pageNum, listLimit);
		
		close(con);
		
		return storeList;
	}

}























