package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.NoticeDetailService;
import vo.ActionForward;
import vo.community.NoticeDTO;

public class NoticeModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		//수정할 글 번호 가져오기
		int no_idx = Integer.parseInt(request.getParameter("no_idx"));
		
		//상세조회
		NoticeDetailService service = new NoticeDetailService();
		NoticeDTO notice = service.getNoticeDetail(no_idx);
		
		request.setAttribute("notice", notice);
		
		forward = new ActionForward();
		forward.setPath("community/notice_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}