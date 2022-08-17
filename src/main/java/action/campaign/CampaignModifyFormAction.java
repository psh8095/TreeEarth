package action.campaign;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.campaign.*;

public class CampaignModifyFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignModifyFormAction");
		
		ActionForward forward = null;
		
		//수정할 글번호 가져오기
		int cam_idx = Integer.parseInt(request.getParameter("cam_idx"));
		
		//수정할 게시물 상세 정보 조회
		CampaignDetailService service = new CampaignDetailService();
		CampaignDTO campaign = service.getCampaignDetail(cam_idx);
		
		//리턴받은 게시물 정보 request에 저장
		request.setAttribute("campaign", campaign);
		
		//campaign_modify.jsp 페이지로 포워딩
		forward = new ActionForward();		
		forward.setPath("campaign/campaign_modify.jsp");
		forward.setRedirect(false);
		
		return null;
	}

}
