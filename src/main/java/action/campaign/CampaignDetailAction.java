package action.campaign;

import javax.servlet.http.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.campaign.*;

public class CampaignDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CampaignDetailAction");
		
		ActionForward forward = null;
		
		//캠페인 글 번호 가져오기
		int cam_idx = Integer.parseInt(request.getParameter("cam_idx"));
//		System.out.println(board_num);
		
		//조회수 증가 요청
		CampaignDetailService service = new CampaignDetailService();
		service.increaseReadcount(cam_idx);
		
		//글 상세정보 조회 요청
		CampaignDTO campaign = service.getCampaignDetail(cam_idx);
		
		//조회 결과 저장
		request.setAttribute("campaign", campaign);
		
		//campaign_detail.jsp 페이지 포워딩 설정
		forward = new ActionForward();
		forward.setPath("campaign/campaign_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
