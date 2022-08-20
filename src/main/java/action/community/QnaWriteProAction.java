package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class QnaWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaWriteProAction");
		
		ActionForward forward = null;
		
		String qna_tag = request.getParameter("qna_tag");
		String qna_id = request.getParameter("qna_id");
		
		//파라미터 qna에 저장
		QnaDTO qna = new QnaDTO();
		qna.setQna_id(qna_id);
		qna.setQna_tag(qna_tag);
		qna.setQna_subject(request.getParameter("qna_subject"));
		qna.setQna_content(request.getParameter("qna_content"));
		System.out.println(qna);
		
		//글쓰기 작업 요청
		QnaWriteProService service = new QnaWriteProService();
		boolean isWriteSuccess = false;
		
		if(qna_tag.equals("faq")) {
			if(qna_id.equals("admin")) {
				isWriteSuccess = service.registQna(qna);
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('자주묻는 질문은 관리자만 작성 가능!')");
				out.println("history.back()");
				out.println("</script>");
			}
		} else {
			isWriteSuccess = service.registQna(qna);
		}
		
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 쓰기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("QnaList.cm?qna_tag=" + qna_tag);
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
