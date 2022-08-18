package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class QnaFaqWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaFaqWriteProAction");
		
		ActionForward forward = null;
		
		//파라미터 qnafaq에 저장
		QnaFaqDTO qnafaq = new QnaFaqDTO();
		qnafaq.setFaq_subject(request.getParameter("faq_subject"));
		qnafaq.setFaq_content(request.getParameter("faq_content"));
		
		QnaFaqWriteProService service = new QnaFaqWriteProService();
		boolean isWriteSuccess = service.registFaq(qnafaq);
		
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 쓰기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("QnaFaqList.cm");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
