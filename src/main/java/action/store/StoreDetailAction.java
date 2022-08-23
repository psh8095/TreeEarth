package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreDetailService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreDetailAction");
		
		ActionForward forward = null;
		
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		
		StoreDetailService service = new StoreDetailService();
		StoreDTO store = service.getStore(sto_idx);
		
		request.setAttribute("store", store);
		
		forward = new ActionForward();
		forward.setPath("store/store_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}