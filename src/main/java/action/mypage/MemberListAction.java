package action.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.mypage.MemberListService;
import vo.ActionForward;
import vo.member.MemberDTO;

public class MemberListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberListAction");
		ActionForward forward = null;
		
		MemberListService service = new MemberListService();
		List<MemberDTO> memberList = service.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		forward = new ActionForward();
		forward.setPath("mypage/member_list.jsp");
		return forward;
	}

}
