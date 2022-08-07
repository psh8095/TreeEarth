package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreItemDetailService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreItemDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreItemDetailAction");
		
		ActionForward forward = null;
		
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		
		StoreItemDetailService service = new StoreItemDetailService();
		StoreDTO store = service.getItemDetail(sto_idx);
		
		// 조회 결과 저장
		request.setAttribute("store", store);
		
		// store_item_detail.jsp 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("store/store_item_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
