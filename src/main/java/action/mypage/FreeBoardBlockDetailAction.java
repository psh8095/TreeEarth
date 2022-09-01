package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardBlockDetailService;
import svc.community.FreeBoardDetailService;
import vo.ActionForward;
import vo.community.FreeBoardBlockDTO;
import vo.community.FreeboardDTO;

public class FreeBoardBlockDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardBlockDetailAction");
		
		ActionForward forward = null;
		
		int free_block_ref = Integer.parseInt(request.getParameter("free_block_ref"));
		
		FreeBoardBlockDetailService block_service = new FreeBoardBlockDetailService();
		FreeBoardBlockDTO free_block = block_service.getFeeBoardBlockDetail(free_block_ref);
		
		FreeBoardDetailService free_service = new FreeBoardDetailService();
		FreeboardDTO freeboard = free_service.getBoard(free_block_ref);
		
		request.setAttribute("free_block", free_block);
		request.setAttribute("freeboard", freeboard);
		
		forward = new ActionForward();
		forward.setPath("mypage/block_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
