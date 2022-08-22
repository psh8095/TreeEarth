package action.mypage;

import java.io.PrintWriter;

import javax.servlet.http.*;

import action.*;
import svc.community.CampaignReviewDeleteProService;
import vo.*;

public class CampaignReviewBlockDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockDeleteAction");
		ActionForward forward = null;
		
		int cam_re_ref = Integer.parseInt(request.getParameter("cam_re_ref"));
		
		//신고글 삭제 요청
		CampaignReviewDeleteProService service = new CampaignReviewDeleteProService();
		boolean isDeleteSuccess = service.deleteCampaignReview(cam_re_ref);
		
		if(!isDeleteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("CampaignReviewList.cm");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
