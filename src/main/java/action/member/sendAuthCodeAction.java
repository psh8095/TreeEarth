package action.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.sendAuthCodeService;
import vo.ActionForward;
import vo.member.CreateAuthCode;
import vo.member.MailSMTP;


public class sendAuthCodeAction implements Action {

	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. 이메일 액션");
		ActionForward forward = null;

		
		// ---------------------------------------------------------------------------------

		
			// 폼으로 부터 전송받은 값을 변수에 저장
			request.getParameter("UTF-8");
			String email = request.getParameter("email");
			
			
			// 인증 코드 생성
			CreateAuthCode cac = new CreateAuthCode();
			String authCoue = cac.createAuthCode();
			System.out.println("3-1. 인증코드 =" + authCoue);
			
			
			// 매일전송에 필요한 정보 변수에 저장 
			String sender = "gmp79333@gmail.com"; // 보내는 사람
			String receiver = email; // 받는 사람
			String subject = "[트리케라톱스] 트리어스 가입 인증 메일입니다."; // 메일 제목
			String content =  "인증코드 입니다. " + "\n" + authCoue; // 메일 본문, 코드

		
		// ---------------------------------------------------------------------------------
		
		
		try {
//			 ---------------- 메일 전송을 위한 설정 작업 -----------------
			// 메일 전송 프로토콜 SMTP - TCP 587번 포트 사용
			
			
			// 1. 서버 정보를 담을 객체 생성
			Properties properties = System.getProperties();
			
			
			// 메일 전송에 필요한 기본 설정 정보를 객체에 추가
			properties.put("mail.smtp.host", "smtp.gmail.com"); // 구글(Gmail) SMTP 서버
			properties.put("mail.smtp.auth", "true"); // SMTP 서버에 대한 인증 여부 설정
			properties.put("mail.smtp.port", "587"); // SMTP 서비스 포트 설정
			properties.put("mail.smtp.starttls.enable", "true"); // TLS 인증 사용 여부 설정
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // 인증 프로토콜 버전 설정
			
			
			// 2. 인증 정보를 관리하는 MailSMTP 클래스를 업케스팅 
			Authenticator authenticator = new MailSMTP(); 
			
			
			// 3. 기본 메일 전송 단위인 session 객체 생성
			// 서버정보, 인증정보를 파라미터로 전달
			Session mailSession = Session.getDefaultInstance(properties, authenticator);
			
			
			
			
			// ---------------- 전송할 메일에 대한 정보 설정 -----------------

			
			// 4. 서버와 인증 정보를 포함하는 객체 생성
			// 파라미터로 session객체 전달
			Message mailMessage = new MimeMessage(mailSession); // 업캐스팅
			

			// 5. 전송할 메일에 대한 내용 정보 설정
			Address senderAddress = new InternetAddress(sender, "트리어스");// 발신자 정보 설정
			Address receiverAddress = new InternetAddress(receiver);// 수신자 정보 설정

			mailMessage.setHeader("content-Type", "text/html; charset=UTF-8");// 메일 헤더 정보 설정
			mailMessage.setFrom(senderAddress);// 발신자 정보 설정
			mailMessage.addRecipient(RecipientType.TO, receiverAddress);// 수신자 정보 설정
			mailMessage.setSubject(subject);// 메일 제목 설정
			mailMessage.setContent(content, "text/html; charset=UTF-8");// 메일 본문 설정
			mailMessage.setSentDate(new Date());// 메일 전송 날짜 및 시각 정보 설정
			
			
			// 6. 메일 전송
			Transport.send(mailMessage);
			
			
			
		// ---------------------------------------------------------------------------------

			
			// 서비스 호출(인증코드 입력 작업)
			sendAuthCodeService service = new sendAuthCodeService();
			boolean isRegistSuccess = service.sendAuthCode(email, authCoue); 
			

		// ---------------------------------------------------------------------------------

			
			//코드 등록 성공 판별
			if(!isRegistSuccess) {
				System.out.println("7. 코드 등록 실패");
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("history.back()");
				out.println("</script>");

				
			} else {
				System.out.println("7. 코드 등록 성공");
				forward = new ActionForward();
				forward.setPath("member/checkEmail.jsp");
				forward.setRedirect(false);
				
			} 
			

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// ----------------------------------------------------------------------------------------

		
		return forward;
	}

}
