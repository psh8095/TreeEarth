package action.community;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class DiaryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3.DiaryListAction");
		ActionForward forward = null;
		
		//페이징처리 변수
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
		
		ArrayList<DiaryDTO> diaryList = DiaryListService.getDiaryList(pageNum, listLimit);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("diaryList", diaryList);
//		System.out.println(pageInfo.getListCount());
//		System.out.println(boardList);
		
		forward = new ActionForward();
		forward.setPath("community/diary_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
