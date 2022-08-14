package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;
import vo.member.*;

public class FindIdPhoneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindIdPhoneAction");
		
		ActionForward forward = null;

//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3"));
		
		MemberDTO member = new MemberDTO();
		member.setMem_name(request.getParameter("name"));
		member.setMem_phone(request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3"));
		
		//
		FindIdService service = new FindIdService();
		boolean isMemberId = service.searchMemberId(member);
		
		if(!isMemberId) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('아이디 찾기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			//아이디 검색 요청 -> alert로 출력
		}
		
		return forward;
	}

}
