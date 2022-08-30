package action.campaign;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.campaign.CampaignApplyListService;
import vo.ActionForward;
import vo.campaign.ApplyListDTO;

public class CampaignApplyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignApplyUserAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		CampaignApplyListService service = new CampaignApplyListService();
		List<ApplyListDTO> applyList = service.getApplyList(sId);
		
		request.setAttribute("applyList", applyList);
		
		forward = new ActionForward();
		forward.setPath("campaign/campaign_apply_list.jsp");
		return forward;
	}

}
