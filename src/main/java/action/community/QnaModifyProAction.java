package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.community.QnaDTO;

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
		
		
		
		return forward;
	}

}
