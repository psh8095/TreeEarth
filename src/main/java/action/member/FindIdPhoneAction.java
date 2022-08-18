package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;

public class FindIdPhoneAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindIdPhoneAction");
		
		ActionForward forward = null;

		String mem_name = request.getParameter("name");
		String mem_phone = request.getParameter("phone1") + request.getParameter("phone2") + request.getParameter("phone3");
		
		//기존 회원	인지 판별 요청
		FindIdPhoneService service = new FindIdPhoneService();
		String mem_id = service.searchMemberId(mem_name, mem_phone);
		
		if(mem_id == null) {
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
