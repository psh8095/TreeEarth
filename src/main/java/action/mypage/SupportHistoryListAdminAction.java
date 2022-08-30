package action.mypage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.support.MoneyHistoryService;
import vo.ActionForward;
import vo.support.SupportHistoryDTO;

public class SupportHistoryListAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SupportHistoryListAdminAction");
		ActionForward forward = null;
		
		MoneyHistoryService service = new MoneyHistoryService();
		ArrayList<SupportHistoryDTO> supList = service.getSupportHistory();
		
		request.setAttribute("supList", supList);
		
		forward = new ActionForward();
		forward.setPath("mypage/support_list_admin.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
