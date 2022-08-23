package svc.store;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StoreDAO;
import vo.mypage.OrderDTO;
import vo.store.StoreDTO;
import vo.store.StoreReviewDTO;

public class StoreOrderListService {

	public int getListCount() {
		int listCount = 0;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		listCount = dao.selectStoreOrderListCount();
		
		close(con);
		
		return listCount;
	}
	
	public ArrayList<OrderDTO> getBoardList(int pageNum, int listLimit) {
		ArrayList<OrderDTO> orderList = null;
		
		Connection con = getConnection();
		StoreDAO dao = StoreDAO.getInstance();
		dao.setConnection(con);
		
		// OrderDTO 객체의 selectStoreOrderList() 메서드를 호출하여 게시물 목록 조회
		// => 파라미터 : 현재 페이지 번호(pageNum), 페이지 당 게시물 수(listLimit)
		//    리턴타입 : ArrayList<OrderDTO> orderList
		orderList = dao.selectStoreOrderList(pageNum, listLimit);
		
		close(con);
		
		return orderList;
	}

}

