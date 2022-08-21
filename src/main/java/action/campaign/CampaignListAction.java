package action.campaign;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.campaign.*;

public class CampaignListAction implements Action {
			
		@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("CampaignListAction");
			
			ActionForward forward = null;
			
			//페이징 처리를 위한 변수 선언
			int pageNum = 1;
			int listLimit = 10;
			int pageLimit = 10;
			
			//pageNum에 현재 페이지 번호 저장
			if(request.getParameter("pageNum") != null) {
					pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
			
			//전체 게시물 갯수 조회 작업 요청
			CampaignListService service = new CampaignListService();
			int listCount = service.getCampaignListService();
			
			int maxPage = (int)Math.ceil((double)listCount / listCount);
			int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
			int endPage = startPage + pageLimit - 1;
			
			if(endPage > maxPage) {
					endPage = maxPage;
			}
			
			//페이지 정보를 PageInfo 객체에 저장
//			PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
			
			//---------------------------------------------------------------------------------
			//게시물 목록 가져오기
			ArrayList<CampaignDTO> campaignList = CampaignListService.getCampaignList();
			
//			request.setAttribute("pageInfo", "pageInfo");
			request.setAttribute("campaignList", campaignList);
			
			forward = new ActionForward();
			forward.setPath("campaign/campaign_list.jsp");
			forward.setRedirect(false);
			
			return forward;
	}

}

