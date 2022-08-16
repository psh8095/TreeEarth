package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreReviewDetailService;
import vo.ActionForward;
import vo.store.StoreReviewDTO;

public class StoreReviewDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewDetailAction");
		
		ActionForward forward = null;
		
		// 상품 구매후기 글번호 가져와서 저장
		int sto_re_idx = Integer.parseInt(request.getParameter("sto_re_idx"));
		System.out.println(sto_re_idx); // 확인용
		
		// 후기 상세내용 조회 요청 작업
		StoreReviewDetailService service = new StoreReviewDetailService();
		StoreReviewDTO store_review = service.getStoreReviewDetail(sto_re_idx);
		
		request.setAttribute("store_review", store_review);
		
		// 후기 상세내용 뷰 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("store/store_review_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
