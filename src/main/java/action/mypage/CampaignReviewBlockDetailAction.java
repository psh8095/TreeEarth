package action.mypage;

import javax.servlet.http.*;

import action.*;
import vo.*;

public class CampaignReviewBlockDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockDetailAction");
		ActionForward forward = null;
		
		int cam_re_block_ref = Integer.parseInt(request.getParameter("cam_re_block_ref"));
		System.out.println(cam_re_block_ref);
		
		
		
		return forward;
	}

}
