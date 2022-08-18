package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.CheckAuthCodeService;
import svc.member.FindIdEmailService;
import svc.member.FindPassService;
import vo.ActionForward;
import vo.member.AuthDTO;

public class CheckPassResultAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindPassResultAction");
		
		ActionForward forward = null;
		
		String mem_id = request.getParameter("mem_id");
		String mem_email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String authCode = request.getParameter("authCode");
		System.out.println(mem_email + authCode);
		
		AuthDTO auth = new AuthDTO();
		auth.setMem_email(mem_email);
		auth.setMem_auth(authCode);
		
		//인증코드 비교 요청
		CheckAuthCodeService service = new CheckAuthCodeService();
		int checkAuthCode = service.checkAuthCode(auth);
		System.out.println("auth : " + checkAuthCode);
		
		//인증코드 불일치
		if(checkAuthCode == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('인증코드 불일치')");
			out.println("history.back()");
			out.println("</script>");
			
		//인증코드 일치
		} else {
			//회원 비밀번호 가져오기
			FindPassService passService = new FindPassService();
			String mem_pass = passService.searchMemberPass(mem_id, mem_email);
			System.out.println(mem_pass);
			
			if(mem_pass == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				
				out.println("<script>");
				out.println("alert('비밀번호 찾기 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("FindPassResult.me?mem_pass=" + mem_pass);
				forward.setRedirect(true);
			}
			
		} 
		
		return forward;
	}

}
