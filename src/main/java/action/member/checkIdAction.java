package action.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.CheckIdService;
import vo.ActionForward;

public class checkIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. 아이디 액션");
		ActionForward forward = null;
		
		
		// ----------------------------------------------------------------------------------------

		
		// 폼으로 부터 전송받은 값을 변수에 저장
		request.getParameter("UTF-8");
		String id = request.getParameter("id");
		
		
		// ----------------------------------------------------------------------------------------

		
		// 서비스 호출(인증코드를 비교하는 작업)
		CheckIdService service = new CheckIdService();
		int checkId = service.checkId(id);
				
				
		// ----------------------------------------------------------------------------------------
		
		
		//인증 코드 일치 판별
		//인증코드 불일치
		if(checkId == 0) {
			System.out.println("7. 아이디 중복");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 중복')");
			out.println("history.back()");
			out.println("</script>");
					
					
		//인증코드 일치	
		} else if(checkId == 1){
					
			System.out.println("7. 아이디 체크 완료");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 체크 완료.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
