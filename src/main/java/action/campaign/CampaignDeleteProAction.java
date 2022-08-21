package action.campaign;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;

public class CampaignDeleteProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignDeleteProAction");
		
		ActionForward forward = null;
		
		//글번호, 패스워드 가져오기
		int cam_idx = Integer.parseInt(request.getParameter("cam_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		//삭제 권한 판별 요청
		CampaignDeleteProService service = new CampaignDeleteProService();
		
		boolean isDeleteSuccess = service.deleteCampaign(cam_idx);
		
		//삭제 결과 판별
		if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패')");
				out.println("history.back()");
				out.println("</script>");
		} else { //글목록 페이지 요청
				forward = new ActionForward();
				forward.setPath("CampaignList.cp?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
		}
		return forward;
	}
	
}