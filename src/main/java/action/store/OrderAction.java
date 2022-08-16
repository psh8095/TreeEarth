package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.store.OrderService;
import vo.ActionForward;
import vo.store.OrderDTO;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderAction");
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
		
		OrderService service = new OrderService();
		service.insertOrder(order);
		
		return forward;
	}

}
