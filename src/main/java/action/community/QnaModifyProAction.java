package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class QnaModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaModifyProAction");
		ActionForward forward = null;
		
		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		
		QnaDTO qna = new QnaDTO();
		qna.setQna_idx(qna_idx);
		qna.setQna_id(request.getParameter("qna_id"));
		qna.setQna_subject(request.getParameter("qna_subject"));
		qna.setQna_content(request.getParameter("qna_content"));
		
		QnaModifyProService service = new QnaModifyProService();
		//기존글에 답변 추가
		boolean isModifySuccess = service.modifyQna(qna);
		
		if(!isModifySuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답변완료!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("QnaList.cm?qna_tag=" + qna.getQna_tag());
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
