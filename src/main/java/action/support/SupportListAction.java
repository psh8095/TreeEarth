package action.support;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.*;
import svc.support.SupportListService;
import vo.*;
import vo.support.SupportDTO;

public class SupportListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. SupportList 액션");
		ActionForward forward = null;
		
		int pageNum = 1; 
		int listLimit = 10;
		int pageLimit = 10; 

		//pageNum에 현재 페이지 번호 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		DiaryListService service = new DiaryListService();	
		int diaryListCount = service.getDiaryListCount();
		
		int maxPage = (int)Math.ceil((double)diaryListCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, diaryListCount);
		
		
	// ----------------------------------------------------------------------------------------

		//서비스 호출(리스트 조회)
		SupportListService Service = new SupportListService();
		ArrayList<SupportDTO> SupportList = Service.getSupportList();
		
		
		//리턴값 리스트에 전달
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("SupportList", SupportList);
		
	// -------------------------------------------------------------------------------------
		
		System.out.println("7. 리스트 성공");
		// 후원 페이지로 이동	
		forward = new ActionForward();
		forward.setPath("support/support_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
