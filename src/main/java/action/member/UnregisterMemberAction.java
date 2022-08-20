package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.UnregisterMemberService;
import vo.ActionForward;

public class UnregisterMemberAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UnregisterMemberAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		UnregisterMemberService service = new UnregisterMemberService();
		service.deleteMember(sId);
		
		forward = new ActionForward();
		forward.setPath("./");
		
		return forward;
	}

}
