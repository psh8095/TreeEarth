package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

public class CampaignExpiredListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignExpiredListAction");
		ActionForward forward = null;
		
		
		forward = new ActionForward();
		forward.setPath("campaign/campaign_list.jsp");
		
		return forward;
	}

}