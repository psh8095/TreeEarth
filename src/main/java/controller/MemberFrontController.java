package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.member.*;
import vo.*;

//회원 컨트롤러
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {

	
	// --------------------------------------------------------------------------------------
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("==============================");
		System.out.println("1. 컨트롤러");
		
		
	// --------------------------------------------------------------------------------------

				
		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("2. 입력 주소 = "+ command);
		
		// 액션 클래스 인스턴스들을 관리하는 변수 선언
		Action action = null;
		
		// 포워딩을 관리하는 타입 변수 선언
		ActionForward forward = null;	
		
		
	// @회원가입@ --------------------------------------------------------------------------------------
		
		//서블릿 판별문
		
		
		// 1. 약관 폼
		if(command.equals("/dirrhks.me")) {
			forward = new ActionForward();
			forward.setPath("member/dirrhks.jsp");
			forward.setRedirect(false);
			
			
	// --------------------------------------------------------------------------------------
		
		
		// 2. 본인인증 폼
		} else if(command.equals("/qhsdlsdlswmd.me")) {
			forward = new ActionForward();
			forward.setPath("member/qhsdlsdlswmd.jsp");
			forward.setRedirect(false);
			
		
		//3. 이메일 체크 폼 
		} else if(command.equals("/checkEmail.me")) {
			forward = new ActionForward();
			forward.setPath("member/checkEmail.jsp");
			forward.setRedirect(false);
		
		
		//3 - 1. 인증 메일 전송
		} else if(command.equals("/sendAuthCodeAction.me")) {
			try {
				action = new sendAuthCodeAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		//3 - 2. 인증 메일 확인
		} else if(command.equals("/checkAuthCodeAction.me")) {
			try {
				action = new checkAuthCodeAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	// --------------------------------------------------------------------------------------
	
			
		//4. 정보 입력 폼
		} else if(command.equals("/joinForm.me")) {
			forward = new ActionForward();
			forward.setPath("member/joinForm.jsp");
			forward.setRedirect(false);
			
			
		//4 - 1. 아이디 중복 체크
		} else if(command.equals("/checkIdAction.me")) {
			try {
				action = new checkIdAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		//4 - 2. 회원가입 액션
		} else if(command.equals("/joinProAction.me")) {
			try {
				action = new joinProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	// --------------------------------------------------------------------------------------
	
			
		//5. 회원가입 성공 폼
		} else if(command.equals("/joinSuccess.me")) {
			forward = new ActionForward();
			forward.setPath("member/joinSuccess.jsp");
			forward.setRedirect(false);
		
		
	// @로그인@ --------------------------------------------------------------------------------------
		
			
		//로그인 폼
		} else if(command.equals("/MemberLoginForm.me")) { 
			forward = new ActionForward();
			forward.setPath("member/member_login.jsp");
			forward.setRedirect(false);

		} else if(command.equals("/MemberLoginPro.me")) { //로그인 작업
			try {
				action = new MemberLoginProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberFrontController - MemberLoginPro 오류");
			}

		} else if(command.equals("/MemberLogout.me")) { // 로그아웃
			try {
				action = new MemberLogoutAction(); 
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberFrontController - MemberLogout 오류");
			}
		}
		
	// @아이디/비밀번호 찾기@--------------------------------------------------------------------------------------

		else if(command.equals("/FindIdForm.me")) { //아이디 찾기 폼
			forward = new ActionForward();
			forward.setPath("member/find_id.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/FindIdPhone.me")) { //휴대폰으로 아이디 찾기
			try {
				action = new FindIdPhoneAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("MemberFrontController - FindIdPhone 오류");
			}
		} else if(command.equals("/FindIdResult.me")) { //아이디 찾기 결과
			forward = new ActionForward();
			forward.setPath("member/find_id_result.jsp");
			forward.setRedirect(false);
		}
		
	// --------------------------------------------------------------------------------------		
		
		// 포워딩 처리
		if(forward != null) { 
			System.out.println("8. 포워딩");
			System.out.println("==============================");
			
			if(forward.isRedirect()) { 
				// 리다이렉트 방식
				response.sendRedirect(forward.getPath());
			
			} else {
				// 디스패처 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	
	// --------------------------------------------------------------------------------------

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
