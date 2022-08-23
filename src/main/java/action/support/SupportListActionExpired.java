package action.support;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.support.SupportListService;
import vo.ActionForward;
import vo.support.SupportDTO;

public class SupportListActionExpired implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. SupportList 액션");
		ActionForward forward = null;
		
		
	// ----------------------------------------------------------------------------------------

		//서비스 호출(리스트 조회)
		SupportListService Service = new SupportListService();
		ArrayList<SupportDTO> SupportList = Service.getSupportList();
		
		
		//리턴값 리스트에 전달
		request.setAttribute("SupportList", SupportList);
		
	// -------------------------------------------------------------------------------------
		
		System.out.println("7. 리스트 성공");
		// 후원 페이지로 이동	
		forward = new ActionForward();
		forward.setPath("support/support_list_expired.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
