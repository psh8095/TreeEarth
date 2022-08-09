package action.community;

import java.util.ArrayList;

import javax.servlet.http.*;

import action.*;
import svc.community.CampaignReviewListService;
import vo.*;
import vo.community.CampaignReviewDTO;
import vo.store.StorePageInfo;

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
		
		StorePageInfo pageInfo = new StorePageInfo(pageNum, maxPage, startPage, endPage, listCount);
		
		ArrayList<CampaignReviewDTO> campaignReviewList = CampaignReviewListService.getCampaignReviewList(pageNum, listLimit);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", campaignReviewList);
//		System.out.println(pageInfo.getListCount());
//		System.out.println(boardList);
		
		forward = new ActionForward();
		forward.setPath("campaign_review_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
