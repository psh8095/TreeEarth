package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;

public class CampaignReviewDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignReviewDeleteProAction");
		
		ActionForward forward = null;
		
		int cam_re_idx = Integer.parseInt(request.getParameter("cam_re_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		//삭제 권한 판별 요청
		CampaignReviewDeleteProService service = new CampaignReviewDeleteProService();
		boolean isCampaignReviewWriter = service.isCampaignReviewWriter(cam_re_idx, mem_pass);
		
		if(!isCampaignReviewWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 아니면(패스워드 일치할 경우 = 권한 있을 경우)
			// BoardDeleteProService - removeBoard() 메서드를 호출하여 삭제 요청
			// => 파라미터 : 글번호    리턴타입 : boolean(isDeleteSuccess)
			// (BoardDAO - deleteBoard())
			boolean isDeleteSuccess = service.deleteCampaignReview(cam_re_idx);
			
			// 삭제 결과 판별
			// 삭제 실패 시 자바스크립트로 "삭제 실패!" 출력 후 이전페이지로 돌아가기
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// 글목록(BoardList.bo) 페이지 요청 => 페이지번호 전달
				forward = new ActionForward();
				forward.setPath("CampaignReviewList.cm?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
