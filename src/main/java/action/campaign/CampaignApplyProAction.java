package action.campaign;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.campaign.CampaignApplyProService;
import vo.ActionForward;
import vo.campaign.CampaignApplyDTO;

public class CampaignApplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignApplyProAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		CampaignApplyDTO apply = new CampaignApplyDTO();
		apply.setCam_idx(Integer.parseInt(request.getParameter("cam_idx")));
		apply.setMem_id(sId);
		apply.setMem_name(request.getParameter("mem_name"));
		apply.setMem_phone(request.getParameter("mem_phone"));
		apply.setMem_email(request.getParameter("mem_email"));
		apply.setApply_people(Integer.parseInt(request.getParameter("apply_people")));
		apply.setApply_etc(request.getParameter("apply_etc"));
		
		CampaignApplyProService service = new CampaignApplyProService();
		service.insertApply(apply);
		
		
		forward = new ActionForward();
		forward.setPath("./");
		return forward;
	}

}