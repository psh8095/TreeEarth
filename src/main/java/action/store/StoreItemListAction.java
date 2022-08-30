package action.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreItemListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.store.StoreDTO;

public class StoreItemListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreItemListAction");
		
		ActionForward forward = null;
		
		String sto = request.getParameter("sto_category"); // 스토어 카테고리 파라미터 가져오기
		
		int pageNum = 1; 
		int listLimit = 12; 
		int pageLimit = 3;
		
		// 현재 페이지번호(pageNum)가 전달되었을 경우 가져와서 변수에 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		// 페이징 처리에 필요한 전체 상품 목록 갯수 조회 작업
		// StoreItemListService 클래스 인스턴스 생성 후 getItemListCount() 메서드 호출하여 총 상품 목록 갯수 조회
		// 파라미터 : 없음, 리턴타입 : int(itemListCount)
		StoreItemListService service = new StoreItemListService();
		int itemListCount = service.getItemListCount(sto);
		System.out.println("전체 상품 목록 수 : " + itemListCount);
		//------------------------------------------------------------------
		// 1. 현재 페이지에서 표시할 전체 페이지 수 계산
		int maxPage = (int)Math.ceil((double)itemListCount / listLimit);

		//2. 현재 페이지에서 보여줄 시작 페이지 번호(1, 4, 7 등의 시작 번호) 계산
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;

		//3. 현재 페이지에서 보여줄 끝 페이지 번호(3, 6, 9 등의 끝 번호) 계산
		int endPage = startPage + pageLimit - 1;

		//4. 만약, 끝 페이지(endPage)가 현재 페이지에서 표시할 총 페이지 수(maxPage)보다 클 경우 끝 페이지 번호를 총 페이지 수로 대체
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이징 처리 정보를 StorePageInfo 객체에 저장
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		
		// StoreItemListService 객체의 getStoreItemList() 메서드 호출하여 상품 목록 가져오기
		// 파라미터 : 현재 페이지 번호(pageNum), 페이지 당 상품 목록 수(listLimit)
		// 리턴타입 : ArrayList<StoreDTO>(storeList)
		ArrayList<StoreDTO> storeList = service.getStoreItemList(pageNum, listLimit, sto);
		
//		System.out.println(pageInfo.getItemListCount());
//		System.out.println(storeList); // 확인 후 주석 처리
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("storeList", storeList);
		request.setAttribute("sto_category", sto); // store_main 뷰페이지에서 페이징 처리시 필요한 sto_category 속성 값 저장
		
		forward = new ActionForward();
		forward.setPath("store/store_main.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}






























