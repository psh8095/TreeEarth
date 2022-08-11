package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewBlockFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockFormAction");
		
		ActionForward forward = null;
		
		//신고할 글 번호 가져오기
		int cam_re_idx = Integer.parseInt(request.getParameter("cam_re_idx"));
		
		CampaignReviewDetailService service = new CampaignReviewDetailService();
		CampaignReviewDTO campaign_review = service.getCampaignReviewDetail(cam_re_idx);
		
		request.setAttribute("campaign_review", campaign_review);
		
		forward = new ActionForward();
		forward.setPath("community/campaign_review_block.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
