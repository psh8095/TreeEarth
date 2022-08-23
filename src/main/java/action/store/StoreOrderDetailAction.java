package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreDetailService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreOrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreOrderDetailAction");
		
		ActionForward forward = null;
		
		int order_id = Integer.parseInt(request.getParameter("order_id"));
		
		StoreDetailService service = new StoreDetailService();
		StoreDTO store = service.getStore(order_id);
		
		request.setAttribute("store", store);
		
		forward = new ActionForward();
		forward.setPath("store/store_order_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}