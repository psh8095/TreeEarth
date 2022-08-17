package svc.mypage;

import vo.store.OrderDTO;
import vo.store.OrderDetailDTO;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.List;

import dao.OrderDAO;

public class OrderListService {

	public List<OrderDTO> getOrderInfo(String sId) {
		System.out.println("OrderListService");
		List<OrderDTO> orderList = null;
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setCon(con);
		
		orderList = dao.selectOrderInfo(sId);
		
		close(con);
		
		return orderList;
	}

	public OrderDetailDTO getOrderDetail(String order_id) {
		System.out.println("OrderListService");
		OrderDetailDTO orderDetail = null;
		
		Connection con = getConnection();
		OrderDAO dao = OrderDAO.getInstance();
		dao.setCon(con);
		
		orderDetail = dao.selectOrderDetail(order_id);
		
		close(con);
		
		return orderDetail;
	}



}
