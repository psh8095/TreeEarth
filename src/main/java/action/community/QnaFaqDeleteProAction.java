package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.QnaFaqDeleteProService;
import vo.ActionForward;

public class QnaFaqDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaFaqDeleteProAction");
		
		ActionForward forward = null;
		
		int faq_idx = Integer.parseInt(request.getParameter("faq_idx"));
		String mem_pass = request.getParameter("mem_pass");
//		System.out.println(faq_idx + mem_pass);
		
		//삭제 권한 판별
		QnaFaqDeleteProService service = new QnaFaqDeleteProService();
		boolean isQnaFaqWriter = service.isQnaFaqWriter(faq_idx, mem_pass);
		
		if(!isQnaFaqWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
			
		} else { 
			boolean isDeleteSuccess = service.deleteQnaFaq(faq_idx);
			
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("QnaFaqList.cm");
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
