package action;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.StoreItemListService;
import vo.ActionForward;
import vo.StoreDTO;
import vo.StorePageInfo;

public class StoreItemListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreItemListAction");
		
		ActionForward forward = null;
		
		//------------------------------------------------------------
		// 페이징 처리를 위한 변수 선언
		int pageNum = 1; // 현재 페이지 번호->기본값 1 페이지로 설정
		int listLimit = 9; // 한 페이지 당 표시할 상품 목록 수
		int pageLimit = 3; // 한 페이지 당 표시할 페이지 목록 수
		
		// URL 파라미터로 현재 페이지번호(pageNum)가 전달되었을 경우 가져와서 변수에 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		// 페이징 처리에 필요한 전체 상품 목록 갯수 조회 작업
		// StoreItemListService 클래스 인스턴스 생성 후 getItemListCount() 메서드 호출하여 총 상품 목록 갯수 조회
		// 파라미터 : 없음, 리턴타입 : int(itemListCount)
		StoreItemListService service = new StoreItemListService();
		int itemListCount = service.getItemListCount(); 
		System.out.println("전체 상품 목록 수 : " + itemListCount);
		//------------------------------------------------------------------
		// 페이징 처리를 위한 계산 작업
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
		StorePageInfo pageInfo = new StorePageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		//-------------------------------------------------------------------
		// StoreItemListService 객체의 getStoreItemList() 메서드 호출하여 상품 목록 가져오기
		// 파라미터 : 현재 페이지 번호(pageNum), 페이지 당 상품 목록 수(listLimit)
		// 리턴타입 : ArrayList<StoreDTO>(storeList)
		ArrayList<StoreDTO> storeList = service.getStoreItemList(pageNum, listLimit);
		
//		System.out.println(pageInfo.getItemListCount());
//		System.out.println(storeList); // 잠시 주석 처리
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("storeList", storeList);
		
		// store_main.jsp 페이지 지정 및 포워딩
		forward = new ActionForward();
		forward.setPath("main/store_main.jsp");
		forward.setRedirect(false);
		

		return forward;
	}

}






























