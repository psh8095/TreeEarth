package action.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.support.MoneyHistoryService;
import vo.ActionForward;
import vo.member.MemberDTO;
import vo.support.SupportHistoryDTO;

public class SupportHistoryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SupportHistoryListAction");
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String mem_id = session.getAttribute("sId").toString();
		
		MoneyHistoryService service = new MoneyHistoryService();
		ArrayList<SupportHistoryDTO> supList = service.getSupportHistory(mem_id);
		
		request.setAttribute("supList", supList);
		
		forward = new ActionForward();
		forward.setPath("mypage/support_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
