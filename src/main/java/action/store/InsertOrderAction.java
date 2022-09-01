package action.store;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.store.insertOrderService;
import vo.ActionForward;
import vo.mypage.OrderDTO;
import vo.mypage.OrderDetailDTO;

public class InsertOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertOrderAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
//		System.out.println(request.getParameter("order_id"));
//		System.out.println(request.getParameter("mem_name"));
//		System.out.println(request.getParameter("mem_phone"));
//		System.out.println(request.getParameter("mem_email"));
//		System.out.println(Integer.parseInt(request.getParameter("amount")));
//		System.out.println(request.getParameter("mem_address"));
		
		OrderDTO order = new OrderDTO();
		order.setOrder_id(request.getParameter("order_id"));
		order.setMem_id(sId);
		order.setMem_name(request.getParameter("mem_name"));
		order.setMem_phone(request.getParameter("mem_phone"));
		order.setMem_email(request.getParameter("mem_email"));
		order.setAmount(Integer.parseInt(request.getParameter("amount")));
		order.setMem_address(request.getParameter("mem_address"));
		
		insertOrderService service = new insertOrderService();
		service.insertOrder(order);
		
		String[] sto_idx = request.getParameterValues("sto_idx[]");
		String[] quantity = request.getParameterValues("quantity[]");
		
		// 데이터 확인용 출력
//		System.out.println(sto_idx.length);
//		System.out.println(quantity.length);
//		for(int i = 0; i < sto_idx.length; i++) {
//			System.out.println(sto_idx[i]);
//			System.out.println(quantity[i]);
//		}
		
		for(int i = 0; i < sto_idx.length; i++) {
			OrderDetailDTO orderDetail = new OrderDetailDTO();
			
			orderDetail.setOrder_id(request.getParameter("order_id"));
			orderDetail.setSto_idx(Integer.parseInt(sto_idx[i]));
			orderDetail.setQuantity(Integer.parseInt(quantity[i]));
			
			service.insertOrderDetail(orderDetail);
		}
		
		return forward;
	}

}
