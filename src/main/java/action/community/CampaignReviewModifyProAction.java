package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewModifyProAction");
		
		ActionForward forward = null;
		
		int cam_re_idx = Integer.parseInt(request.getParameter("cam_re_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		CampaignReviewDTO campaign_review = new CampaignReviewDTO();
		campaign_review.setCam_re_idx(Integer.parseInt(request.getParameter("cam_re_idx")));
		campaign_review.setCam_re_id(request.getParameter("cam_re_id"));
		campaign_review.setCam_re_subject(request.getParameter("cam_re_subject"));
		campaign_review.setCam_re_content(request.getParameter("cam_re_content"));
		
		//게시물 수정 권한 판별 요청
		CampaignReviewModifyProService service = new CampaignReviewModifyProService();
		boolean isCampaignReviewWriter = service.isCampaignReviewWriter(cam_re_idx, mem_pass);
		
		if(!isCampaignReviewWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한 없음!')");
			out.println("history.back()");
			out.println("</script>");
		} else { 
			//글 수정 작업 요청
			boolean isModifySuccess = service.modifyCampaignReview(campaign_review);
			
			//글 수정 작업 결과
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("CampaignReviewDetail.cm?cam_re_idx=" + cam_re_idx + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
