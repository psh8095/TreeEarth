package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.CampaignReviewDetailService;
import svc.community.FreeBoardDetailService;
import vo.ActionForward;
import vo.community.CampaignReviewDTO;
import vo.community.FreeboardDTO;

public class FreeBoardBlockFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardBlockFormAction");
		
		ActionForward forward = null;
		
		//신고할 글 번호 가져오기
		int free_idx = Integer.parseInt(request.getParameter("free_idx"));
		
		FreeBoardDetailService service = new FreeBoardDetailService();
		FreeboardDTO freeboard = service.getBoard(free_idx);
		
		request.setAttribute("freeboard", freeboard);
		
		forward = new ActionForward();
		forward.setPath("community/freeboard_block.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
