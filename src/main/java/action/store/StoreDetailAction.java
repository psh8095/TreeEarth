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
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		StoreDetailService service = new StoreDetailService();
		service.increaseReadcount(board_num);
		
		StoreDTO store = service.getStore(board_num);
		
		request.setAttribute("store", store);
		
		forward = new ActionForward();
		forward.setPath("store/store_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}