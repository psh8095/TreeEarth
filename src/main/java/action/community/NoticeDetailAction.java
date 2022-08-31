package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.NoticeDetailService;
import vo.ActionForward;
import vo.community.NoticeDTO;

public class NoticeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("NoticeDetailAction");
		
		ActionForward forward = null;
		
		int no_idx = Integer.parseInt(request.getParameter("no_idx"));

		NoticeDetailService service = new NoticeDetailService();
		NoticeDTO notice = service.getNoticeDetail(no_idx);
		
		request.setAttribute("notice", notice);
		
		forward = new ActionForward();
		forward.setPath("community/notice_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}