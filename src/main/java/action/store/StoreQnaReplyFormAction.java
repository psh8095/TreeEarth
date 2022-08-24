package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaDetailService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaReplyFormAction");

		ActionForward forward = null;
		
		// 답글 작성에 필요한 문의글 번호 파라미터 가져오기
		int sto_qna_idx = Integer.parseInt(request.getParameter("sto_qna_idx"));
		
		// 답글 작성에 필요한 게시물 상세 정보 조회를 위해
		// 기존에 정의된 StoreQnaDetailService 클래스의 getStoreQnaDetail() 메서드를 호출하여
		// 게시물 상세 정보를 리턴받아 store_qna_reply.jsp 페이지로 포워딩
		// => 단, 조회수 증가 작업은 수행하지 않음
		StoreQnaDetailService service = new StoreQnaDetailService();
		StoreQnaDTO store_qna = service.getStoreQnaDetail(sto_qna_idx);
		
		// 리턴받은 게시물 정보(StoreQnaDTO 객체)를 request 객체에 저장
		request.setAttribute("sto_qna_idx", sto_qna_idx);
		
		// store 디렉토리의 store_qna_reply.jsp 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("store/store_qna_reply.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}