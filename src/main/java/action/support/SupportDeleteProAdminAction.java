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
			System.out.println("3. SupportDeleteProAdminAction");
			
			//글 삭제를 위하여 판별하기 위해 글 번호와 비밀번호 파라미터 가져오기
			int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
			String mem_pass = request.getParameter("mem_pass");
			
			SupportDeleteProAdminService service = new SupportDeleteProAdminService();
		boolean isBoardWriter = service.isBoardWriter(sup_idx, mem_pass); //modify와 동일 메서드
		System.out.println(isBoardWriter);
		if(!isBoardWriter) {
			 response.setContentType("text/html; charset=UTF-8" );
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('삭제 권한이 없습니다!')");
			 out.println("history.back()");
			 out.println("</script>");
		}else{
			System.out.println("5. deleteSupport");
			boolean isDeleteSuccess = service.deleteSupport(sup_idx);
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8" );
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			}else {
				System.out.println("7. 삭제 성공");
				forward = new ActionForward();
				forward.setPath("SupportList.su"); //+ request.getParameter("pageNum")
				forward.setRedirect(true);
			}
		}
			
			
		return forward;
	}

}
