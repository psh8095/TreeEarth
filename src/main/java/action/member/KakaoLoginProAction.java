package action.member;

import javax.servlet.http.*;

import action.*;
import vo.*;

public class KakaoLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("KakaoLoginProAction");
		ActionForward forward = null;
		
		String mem_id = request.getParameter("mem_id");
		System.out.println(mem_id);
		
		return forward;
	}

}
