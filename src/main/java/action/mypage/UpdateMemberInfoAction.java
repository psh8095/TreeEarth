package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.UpdateMemberInfoService;
import vo.ActionForward;
import vo.member.MemberDTO;

public class UpdateMemberInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("UpdateMemberInfoAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		MemberDTO member = new MemberDTO();
		member.setMem_pass(request.getParameter("mem_pass"));
		member.setMem_phone(request.getParameter("mem_phone"));
		member.setMem_address(request.getParameter("mem_address"));
		member.setMem_address_detail(request.getParameter("mem_address_detail"));
		
		UpdateMemberInfoService service = new UpdateMemberInfoService(); 
		service.updateMemberInfo(sId, member);
		
		
		forward = new ActionForward();
		forward.setPath("./");
		return forward;
	}

}
