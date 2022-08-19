package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaDetailService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaModifyFormAction");
		
		ActionForward forward = null;
		
		// 수정할 문의글 번호 가져오기
		int sto_qna_idx = Integer.parseInt(request.getParameter("sto_qna_idx"));
		
		StoreQnaDetailService service = new StoreQnaDetailService();
		StoreQnaDTO store_qna = service.getStoreQnaDetail(sto_qna_idx);
		
		request.setAttribute("store_qna", store_qna);
		
		forward = new ActionForward();
		forward.setPath("store/store_qna_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
