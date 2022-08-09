package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.CheckAuthCodeService;
import vo.ActionForward;
import vo.member.AuthDTO;

public class checkAuthCodeAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. 코드 액션");
		ActionForward forward = null;
		
		
		// ----------------------------------------------------------------------------------------

		
		// 폼으로 부터 전송받은 값을 변수에 저장
		request.getParameter("UTF-8");
		String email = request.getParameter("email");
		String authCode = request.getParameter("authCode");
		
		
		// DTO에 저장
		AuthDTO dto = new AuthDTO();
		dto.setMem_email(email);
		dto.setMem_auth(authCode);
		
		
		// ----------------------------------------------------------------------------------------

		
		// 서비스 호출(인증코드를 비교하는 작업)
		CheckAuthCodeService service = new CheckAuthCodeService();
		int checkAuthCode = service.checkAuthCode(dto);
		
		
		// ----------------------------------------------------------------------------------------

		
		//인증 코드 일치 판별
		//인증코드 불일치
		if(checkAuthCode == 0) {
			System.out.println("7. 인증코드 불일치");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('인증코드 불일치')");
			out.println("history.back()");
			out.println("</script>");
			
			
		//인증코드 일치	
		} else if(checkAuthCode == 1){
			
			System.out.println("7. 인증코드 일치");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('인증이 완료되었습니다.')");
			out.println("opener.location.href='joinForm.me?email="+email+"'");
			out.println("window.close();");
			out.println("</script>");
			
			
		// 이메일 중복 가입	
		} else if(checkAuthCode == 2) {
			System.out.println("7. 이메일 중복");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 중복')");
			out.println("history.back()");
			out.println("</script>");
			
			
		// 이메일 인증오류	
		} else if(checkAuthCode == 3) {
			System.out.println("7. 이메일 인증오류");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이메일 인증오류')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		return forward;
	}

}
