package action.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.CampaignReviewDeleteProService;
import svc.community.FreeBoardDeleteProService;
import vo.ActionForward;

public class FreeBoardBlockDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardBlockDeleteAction");
		ActionForward forward = null;
		
		int free_re_ref = Integer.parseInt(request.getParameter("free_re_ref"));
		
		//신고글 삭제 요청
		FreeBoardDeleteProService service = new FreeBoardDeleteProService();
		boolean isDeleteSuccess = service.removeBoard(free_re_ref);
		
		if(!isDeleteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("FreeBoardList.cm");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
