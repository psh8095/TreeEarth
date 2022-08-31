package action.community;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.NoticeListService;
import vo.ActionForward;
import vo.PageInfo;
import vo.community.NoticeDTO;

public class NoticeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeListAction");
		ActionForward forward = null;
		
		//페이징처리 변수
		int pageNum = 1; 
		int listLimit = 9;
		int pageLimit = 9; 

		//pageNum에 현재 페이지 번호 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		//전체 게시물 수 조회
		NoticeListService service = new NoticeListService();
		int itemListCount = service.getNoticeListCount();
		
		int maxPage = (int)Math.ceil((double)itemListCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		
		ArrayList<NoticeDTO> noticeList = NoticeListService.getNoticeList(pageNum, listLimit);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("noticeList", noticeList);
		
		System.out.println("페이지 : " + pageNum);
		
		forward = new ActionForward();
		forward.setPath("community/notice_list.jsp?pageNum=" + pageNum);
		forward.setRedirect(false);
		
		return forward;
	}

}