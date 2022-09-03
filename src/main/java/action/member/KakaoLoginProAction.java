package action.member;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import vo.*;

public class KakaoLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("KakaoLoginProAction");
		ActionForward forward = null;
		
		String mem_id = request.getParameter("mem_id");
//		System.out.println(mem_id);
		
		HttpSession session = request.getSession();
		session.setAttribute("sId", mem_id);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("opener.location.reload()");
		out.println("window.close();");
		out.println("</script>");
		
		return forward;
	}

}
