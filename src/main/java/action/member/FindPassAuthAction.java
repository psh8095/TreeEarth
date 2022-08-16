package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;

public class FindPassAuthAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindPassAuthAction");
		
		ActionForward forward = null;
		
		String mem_id = request.getParameter("mem_id");
		String mem_email = request.getParameter("email1") + "@" + request.getParameter("email2");
//		System.out.println(mem_id + mem_email);
		
		FindPassAuthService service = new FindPassAuthService();
		boolean isMemberEmail = service.isMemberEmail(mem_id, mem_email);
//		System.out.println(isMemberEmail);
		
		if(isMemberEmail) { //아이디, 이메일 일치 시 인증번호 전송
			
		} else { 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원이 아닙니다')");
			out.println("window.close()");
			out.println("</script>");
		}
		
		return forward;
	}

}
