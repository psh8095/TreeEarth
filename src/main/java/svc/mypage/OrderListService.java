package svc.mypage;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.List;

import dao.OrderDAO;
import vo.mypage.OrderListDTO;

public class OrderListService {

	public List<OrderListDTO> getOrderInfo(String sId) {
		System.out.println("OrderListService");
		List<OrderListDTO> orderList = null;
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setCon(con);
		
		orderList = dao.selectOrderInfo(sId);
		
		close(con);
		
		return orderList;
	}

}
