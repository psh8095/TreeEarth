package action.mypage;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.community.*;

public class CampaignReviewBlockListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockListAction");
		
		ActionForward forward = null;
		
		//전체 게시물 목록 요청
		CampaignReviewBlockListService service = new CampaignReviewBlockListService();
		ArrayList<CampaignReviewBlockDTO> blockList = service.getBlockList();
		
		request.setAttribute("blockList", blockList);
		
		forward = new ActionForward();
		forward.setPath("mypage/block_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
