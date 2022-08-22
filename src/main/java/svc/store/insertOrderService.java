package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OrderDAO;
import vo.mypage.OrderDTO;
import vo.mypage.OrderDetailDTO;

public class insertOrderService {

	public void insertOrder(OrderDTO order) {
		System.out.println("insertOrderService");
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setCon(con);

		int insertCount = dao.insertOrder(order);
		
		if(insertCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
	}

	public void insertOrderDetail(OrderDetailDTO orderDetail) {
		System.out.println("insertOrderService");
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setCon(con);

		int insertCount = dao.insertOrderDetail(orderDetail);
		
		if(insertCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
	}

}
