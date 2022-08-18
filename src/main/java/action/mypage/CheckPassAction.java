package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import svc.mypage.CheckPassService;
import vo.ActionForward;
import vo.member.MemberDTO;

public class CheckPassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CheckPassAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		String mem_pass = request.getParameter("mem_pass");
		
		CheckPassService service = new CheckPassService();
		boolean isPass = service.checkPass(sId, mem_pass);
		MemberInfoService infoService = new MemberInfoService();
		MemberDTO member = infoService.getMemberInfo(sId);
		
		request.setAttribute("isPass", isPass);
		request.setAttribute("member", member);
		
		if(isPass) {
			forward = new ActionForward();
			forward.setPath("mypage/check_true.jsp");
		} else {
			forward = new ActionForward();
			forward.setPath("mypage/check_false.jsp");
		}
		
		return forward;
	}

}
