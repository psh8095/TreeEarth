package action.support;

import java.io.*;

import javax.servlet.http.*;

import action.Action;
import svc.*;
import svc.support.SupportDeleteProAdminService;
import vo.*;

public class SupportDeleteProAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			ActionForward forward = null;
			
			int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
			String sup_pass = request.getParameter("sup_pass");
			
			SupportDeleteProAdminService service = new SupportDeleteProAdminService();
		boolean isBoardWriter = service.isBoardWriter(sup_idx, sup_pass); //modify와 동일 메서드
		if(!isBoardWriter) {
			 response.setContentType("text/html; charset=UTF-8" );
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('삭제 권한이 없습니다!')");
			 out.println("history.back()");
			 out.println("</script>");
		}else{
			boolean isDeleteSuccess = service.deleteSupport(sup_idx);
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8" );
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setPath("SupportList.su?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
			
			
		return forward;
	}

}
