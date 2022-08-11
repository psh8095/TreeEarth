package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewBlockProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewBlockProAction");
		
		ActionForward forward = null;
		
		int cam_re_block_ref = Integer.parseInt(request.getParameter("cam_re_idx"));
		String cam_re_block_id = request.getParameter("cam_re_block_id");
		String cam_re_block_reason = request.getParameter("cam_re_block_content");

		//받아온 데이터 DTO에 저장
		CampaignReviewBlockDTO cam_re_block = new CampaignReviewBlockDTO();
		cam_re_block.setCam_re_block_ref(cam_re_block_ref);
		cam_re_block.setCam_re_block_id(cam_re_block_id);
		cam_re_block.setCam_re_block_reason(cam_re_block_reason);
		
//		System.out.println(cam_re_block);

		//신고하기 작업 요청
		CampaignReviewBlockProService service = new CampaignReviewBlockProService();
		boolean isBlockSuccess = service.registBlock(cam_re_block);
		
		//신고 작업 결과 확인
		if(!isBlockSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('신고 실패!')");
			out.println("window.close()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('신고 완료!')");
			out.println("window.close()");
			out.println("</script>");
		}
		
		return forward;
	}

}
