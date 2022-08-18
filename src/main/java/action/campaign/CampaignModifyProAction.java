package action.campaign;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.campaign.*;

public class CampaignModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignModifyProAction");
		
		ActionForward forward = null;
		
		int cam_idx = Integer.parseInt(request.getParameter("cam_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		CampaignDTO campaign = new CampaignDTO();
		campaign.setCam_idx(Integer.parseInt(request.getParameter("cam_idx")));
		campaign.setCam_subject(request.getParameter("cam_subject"));
		campaign.setCam_content(request.getParameter("cam_content"));
		
		//게시물 수정 권한 판별을 위해 패스워드 비교
		CampaignModifyProService service = new CampaignModifyProService();
		boolean isCampaignWriter = service.isCampaignWriter(cam_idx, mem_pass);
		
		// 수정 가능 여부 판별
		if(!isCampaignWriter) {//패스워드 불일치할 경우
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 권한 없음')");
				out.println("history.back()");
				out.println("</script>");
		} else {//패스워드 일치할 경우
				//글 수정 작업 요청
				boolean isModifySuccess = service.modifyCampaign(campaign);
			
				if(!isModifySuccess) {
						response.setContentType("text/html; charset=UTF-8");
						PrintWriter out = response.getWriter();
						out.println("<script>");
						out.println("alert('글 수정 실패')");
						out.println("history.back()");
						out.println("</script>");
				} else {
						forward = new ActionForward();
						forward.setPath("CampaignDetail.cp?cam_idx=" + campaign.getCam_idx() + "&pageNum=" + request.getParameter("pageNum"));
						forward.setRedirect(true);
				}
		}
		
		return forward;
	}

}
