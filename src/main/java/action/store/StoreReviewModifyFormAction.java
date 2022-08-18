package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreReviewDetailService;
import vo.ActionForward;
import vo.store.StoreReviewDTO;

public class StoreReviewModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewModifyFormAction");
		
		ActionForward forward = null;
		
		// 수정할 후기글 번호 가져오기
		int sto_re_idx = Integer.parseInt(request.getParameter("sto_re_idx"));
		
		StoreReviewDetailService service = new StoreReviewDetailService();
		StoreReviewDTO store_review = service.getStoreReviewDetail(sto_re_idx);
		
		request.setAttribute("store_review", store_review);
		
		forward = new ActionForward();
		forward.setPath("store/store_review_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
