package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.StoreDetailService;
import vo.ActionForward;
import vo.StoreDTO;

public class StoreDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreDetailAction");
		
		ActionForward forward = null;
		
		// request 객체를 통해 전달받은 파라미터(idx_num) 가져오기
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));

		StoreDetailService service = new StoreDetailService();
		service.increaseReadcount(sto_idx);
		
		StoreDTO store = service.getStore(sto_idx);
		
		request.setAttribute("store", store);
		
		forward = new ActionForward();
		forward.setPath("store/store_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
