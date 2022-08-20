package action.community;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewListAction");
		ActionForward forward = null;
		
		//페이징처리 변수
		int pageNum = 1; 
		int listLimit = 10;
		int pageLimit = 10; 

		//pageNum에 현재 페이지 번호 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		//전체 게시물 수 조회
		CampaignReviewListService service = new CampaignReviewListService();
		int itemListCount = service.getCampaignReviewListCount();
		
		int maxPage = (int)Math.ceil((double)itemListCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemListCount);
		
		ArrayList<CampaignReviewDTO> campaignReviewList = CampaignReviewListService.getCampaignReviewList(pageNum, listLimit);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("campaignReviewList", campaignReviewList);
//		System.out.println(pageInfo.getListCount());
//		System.out.println(boardList);
		
		forward = new ActionForward();
		forward.setPath("community/campaign_review_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
