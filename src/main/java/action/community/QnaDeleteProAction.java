package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;

public class QnaDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaDeleteProAction");
		
		ActionForward forward = null;
		
		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		String mem_pass = request.getParameter("mem_pass");
		System.out.println(qna_idx + mem_pass);
		
		//삭제 권한 판별
		QnaDeleteProService service = new QnaDeleteProService();
		boolean isQnaWriter = service.isQnaWriter(qna_idx, mem_pass);

		if(!isQnaWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");

		} else { 
			boolean isDeleteSuccess = service.deleteQna(qna_idx);

			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("QnaList.cm");
				forward.setRedirect(true);
			}
		}

	
		
		return forward;
	}

}
