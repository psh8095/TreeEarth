package action.mypage;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import svc.mypage.*;
import vo.*;
import vo.community.*;

public class CampaignReviewBlockDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockDetailAction");
		ActionForward forward = null;
		
		int cam_re_block_ref = Integer.parseInt(request.getParameter("cam_re_block_ref"));
		System.out.println(cam_re_block_ref);
		
		CampaignReviewBlockDetailService block_service = new CampaignReviewBlockDetailService();
		CampaignReviewBlockDTO cam_re_block = block_service.getCampaignReviewBlockDetail(cam_re_block_ref);
		
		CampaignReviewDetailService re_service = new CampaignReviewDetailService();
		CampaignReviewDTO campaign_review = re_service.getCampaignReviewDetail(cam_re_block_ref);
		
		request.setAttribute("cam_re_block", cam_re_block);
		request.setAttribute("campaign_review", campaign_review);
		
		forward = new ActionForward();
		forward.setPath("mypage/block_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
