package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;

public class FindIdEmailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindIdEmailAction");
		
		ActionForward forward = null;

		String mem_name = request.getParameter("name");
		String mem_email = request.getParameter("email1") + "@" + request.getParameter("email2");
//		System.out.println(mem_name + mem_email);
		
		//기존 회원	인지 판별 요청
		FindIdEmailService service = new FindIdEmailService();
		String mem_id = service.searchMemberId(mem_name, mem_email);
		System.out.println(mem_id);
		
		if(mem_id.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('아이디 찾기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("FindIdResult.me?mem_id=" + mem_id);
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
