package action.mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.campaign.CampaignReviewBlockListService;
import svc.community.FreeBoardBlockListService;
import vo.ActionForward;
import vo.community.CampaignReviewBlockDTO;
import vo.community.FreeBoardBlockDTO;

public class FreeBoardBlockListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardBlockListAction");
		
		ActionForward forward = null;
		
		//전체 게시물 목록 요청
		FreeBoardBlockListService service = new FreeBoardBlockListService();
		ArrayList<FreeBoardBlockDTO> blockList = service.getBlockList();
		
		request.setAttribute("blockList", blockList);
		
		forward = new ActionForward();
		forward.setPath("mypage/block_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
