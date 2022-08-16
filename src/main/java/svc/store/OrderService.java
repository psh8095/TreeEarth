package svc.store;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OrderDAO;
import vo.store.OrderDTO;

public class OrderService {

	public void insertOrder(OrderDTO order) {
		System.out.println("OrderService");
		
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

}
