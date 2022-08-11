package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewDetailAction");
		
		ActionForward forward = null;
		
		//캠페인후기 글번호 가져오기
		int cam_re_idx = Integer.parseInt(request.getParameter("cam_re_idx"));
//		System.out.println(board_num);
		
		//조회수 증가 요청
		CampaignReviewDetailService service = new CampaignReviewDetailService();
		service.increaseReadcount(cam_re_idx);
		
		//상세내용 조회 요청
		CampaignReviewDTO campaign_review = service.getCampaignReviewDetail(cam_re_idx);
		
		request.setAttribute("campaign_review", campaign_review);

		forward = new ActionForward();
		forward.setPath("community/campaign_review_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
