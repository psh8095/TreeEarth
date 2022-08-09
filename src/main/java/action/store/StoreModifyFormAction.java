package action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreItemDetailService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreModifyFormAction");
		
		ActionForward forward = null;
		
		// 글 수정에 필요한 글번호 파라미터 가져오기
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		
		// 글 수정에 필요한 게시물 상세 정보 조회를 위해
		// 기존에 정의된 StoreItemDetailService 클래스의 getItemDetail() 메서드를 호출하여
		// 게시물 상세 정보를 리턴받아 store_modify.jsp 페이지로 포워딩
		// => 단, 조회수 증가 작업은 수행하지 않음
		StoreItemDetailService service = new StoreItemDetailService();
		StoreDTO store = service.getItemDetail(sto_idx);
		
		// 리턴받은 게시물 정보(StoreDTO 객체)를 request 객체에 저장
		request.setAttribute("store", store);
		
		// board 디렉토리의 store_modify.jsp 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("store/store_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}











