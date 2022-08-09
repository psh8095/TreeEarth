package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.CampaignReviewListService;
import vo.*;

public class CampaignReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		//페이징처리 변수
		int pageNum = 1; 
		int listLimit = 10;
		int pageLimit = 10; 

		//pageNum에 현재 페이지 번호 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		CampaignReviewListService service = new CampaignReviewListService();
		int listCount = service.getCampaignReviewListCount();
		
		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
//		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
		
		return forward;
	}

}
