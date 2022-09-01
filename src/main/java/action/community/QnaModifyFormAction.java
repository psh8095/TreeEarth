package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class QnaModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaModifyFormAction");
		ActionForward forward = null;
		
		//수정할 글 번호 가져오기
		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		
		QnaModifyService service = new QnaModifyService();
		//상세조회
		QnaDTO qna = service.getQna(qna_idx);
		
		request.setAttribute("qna", qna);
		
		forward = new ActionForward();
		forward.setPath("community/qna_modify.jsp?qna_idx=" + qna_idx);
		forward.setRedirect(false);
		
		return forward;
	}

}
