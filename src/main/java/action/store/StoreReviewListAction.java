package action.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreReviewListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.store.StoreDTO;
import vo.store.StoreReviewDTO;

public class StoreReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewListAction");
		
		ActionForward forward = null;
		
		// 페이징처리 변수 선언
		int pageNum = 1; 
		int listLimit = 5;
		int pageLimit = 5; 

		// 현재 페이지번호(pageNum)가 전달되었을 경우 변수에 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		// 페이징 처리에 필요한 전체 구매 후기 갯수 조회 작업 요청
		StoreReviewListService service = new StoreReviewListService();
		int itemListCount = service.getStoreReviewListCount();  // 변수명 변경?
		
		int maxPage = (int)Math.ceil((double)itemListCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		
		// StoreReviewListService 객체의 getStoreReviewList() 메서드를 호출하여 구매 후기 목록 가져오기
		ArrayList<StoreReviewDTO> storeReviewList = service.getStoreReviewList(pageNum, listLimit);
		
		// 뷰페이지(jsp)에서 사용할 데이터가 저장된 객체들을 전달하기 위해
		// request 객체의 setAttribute() 메서드를 호출하여 객체 저장
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("storeReviewList", storeReviewList);
//		System.out.println(pageInfo.getItemListCount()); // 확인용
//		System.out.println(storeReviewList); // 확인용
		
//		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
//		System.out.println(sto_idx);
//		request.setAttribute("sto_idx", sto_idx);
		
		StoreDTO store = new StoreDTO();
		store.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store.setSto_subject(request.getParameter("sto_subject"));
		store.setSto_thum_file(request.getParameter("sto_thum_file"));
		store.setSto_thum_real_file(request.getParameter("sto_thum_real_file"));
//		System.out.println(store); // 확인용
		request.setAttribute("store", store);
		
		
		forward = new ActionForward();
		forward.setPath("store/store_review_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
















