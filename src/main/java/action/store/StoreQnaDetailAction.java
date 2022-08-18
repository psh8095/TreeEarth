package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaDetailService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaDetailAction");
		
		ActionForward forward = null;
		
		// 상품 문의 글번호 가져와서 저장
		int sto_qna_idx = Integer.parseInt(request.getParameter("sto_qna_idx"));
		System.out.println(sto_qna_idx); // 확인용
		
		// 문의글 상세내용 조회 요청 작업
		StoreQnaDetailService service = new StoreQnaDetailService();
		StoreQnaDTO store_qna = service.getStoreQnaDetail(sto_qna_idx);
		
		request.setAttribute("store_qna", store_qna);
		
		// 문의 상세내용 뷰 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("store/store_qna_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
