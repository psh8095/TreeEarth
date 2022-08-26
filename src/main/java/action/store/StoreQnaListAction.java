package action.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.store.StoreDTO;
import vo.store.StoreQnaDTO;

public class StoreQnaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaListAction");
		
		ActionForward forward = null;
		
		System.out.println("여기"+request.getParameter("pageNum")); // 페이지 번호 확인용
		// 페이징처리 변수 선언
		int pageNum = 1; 
		int listLimit = 5;
		int pageLimit = 5; 

		// 현재 페이지번호(pageNum)가 전달되었을 경우 변수에 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		// 페이징 처리에 필요한 전체 문의글 갯수 조회 작업 요청
		StoreQnaListService service = new StoreQnaListService();
		int itemListCount = service.getStoreQnaListCount();
		
		int maxPage = (int)Math.ceil((double)itemListCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		StoreDTO store = new StoreDTO();
		store.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		System.out.println(store); // 확인용
		request.setAttribute("store", store);
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		
		// StoreQnaListService 객체의 getStoreQnaList() 메서드를 호출하여 상품 문의글 목록 가져오기
		ArrayList<StoreQnaDTO> storeQnaList = service.getStoreQnaList(pageNum, listLimit, store);
		
		// 뷰페이지(jsp)에서 사용할 데이터가 저장된 객체들을 전달하기 위해
		// request 객체의 setAttribute() 메서드를 호출하여 객체 저장
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("storeQnaList", storeQnaList);
//		System.out.println(pageInfo.getItemListCount()); // 확인용
//		System.out.println(storeQnaList); // 확인용
		
		forward = new ActionForward();
		forward.setPath("store/store_qna_list.jsp?pageNum=" + pageNum);
		forward.setRedirect(false);
		
		return forward;
	}

}














