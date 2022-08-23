package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;
import vo.member.*;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginProAction");
		ActionForward forward = null;
		
		MemberDTO member = new MemberDTO();
		member.setMem_id(request.getParameter("mem_id"));
		member.setMem_pass(request.getParameter("mem_pass"));
		
		MemberLoginProService service = new MemberLoginProService();
		boolean isLoginSuccess = service.loginMember(member);
		
		
		
		if(!isLoginSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('로그인 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			//세션에 로그인한 아이디 저장
			HttpSession session = request.getSession();
			session.setAttribute("sId", member.getMem_id());
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("opener.location.reload()");
			out.println("window.close();");
			out.println("</script>");
		}
		
		return forward;
	}

}
