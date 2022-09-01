package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.CampaignReviewDetailService;
import svc.community.QnaModifyService;
import vo.ActionForward;
import vo.community.CampaignReviewDTO;
import vo.community.QnaDTO;

public class QnaModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaModifyFormAction");
		ActionForward forward = null;
		
		//수정할 글 번호 가져오기
		int qna_idx = Integer.parseInt(request.getParameter("qna_idx"));
		
		QnaModifyService service = new QnaModifyService();
		QnaDTO qna = service.getQna(qna_idx);
		
		request.setAttribute("qna", qna);
		
		forward = new ActionForward();
		forward.setPath("community/qna_modify.jsp?qna_idx=" + qna_idx);
		forward.setRedirect(false);
		
		return forward;
	}

}
