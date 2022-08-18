package action.member;

import java.io.*;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;

import action.*;
import svc.member.*;
import vo.*;
import vo.member.CreateAuthCode;
import vo.member.MailSMTP;

public class FindPassAuthAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FindPassAuthAction");
		
		ActionForward forward = null;
		
		String mem_id = request.getParameter("mem_id");
		String mem_email = request.getParameter("email1") + "@" + request.getParameter("email2");
//		System.out.println(mem_id + mem_email);
		
		//id, email 일치하는 회원 조회 요청
		FindPassAuthService service = new FindPassAuthService();
		boolean isMemberEmail = service.isMemberEmail(mem_id, mem_email);
//		System.out.println(isMemberEmail);
		
		if(!isMemberEmail) { 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원이 아닙니다')");
			out.println("window.close()");
			out.println("</script>");
		} else { //회원 조회 성공 시 인증번호 전송
			
			// 인증 코드 생성
			CreateAuthCode auth = new CreateAuthCode();
			String authCode = auth.createAuthCode();
			System.out.println("인증코드 : " + authCode);
			
			// 매일전송에 필요한 정보 변수에 저장 
			String sender = "gmp79333@gmail.com"; // 보내는 사람
			String receiver = mem_email; // 받는 사람
			String subject = "[트리어스] 트리어스 비밀번호 인증 메일입니다."; // 메일 제목
			String content =  "비밀번호 찾기 인증번호 란에 인증코드를 입력하여주세요. " + "\n" + authCode; // 메일 본문, 코드
			
			try {
				//서버 정보
				Properties properties = System.getProperties();
				
				// 메일 전송에 필요한 기본 설정 정보
				properties.put("mail.smtp.host", "smtp.gmail.com"); 
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.port", "587"); 
				properties.put("mail.smtp.starttls.enable", "true"); 
				properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
				
				//인증 정보
				Authenticator authenticator = new MailSMTP(); 
				
				Session mailSession = Session.getDefaultInstance(properties, authenticator);
				
				Message mailMessage = new MimeMessage(mailSession); 
				
				//전송할 메일에 대한 정보
				Address senderAddress = new InternetAddress(sender, "트리어스"); //발신자
				Address receiverAddress = new InternetAddress(receiver); //수신자

				mailMessage.setHeader("content-Type", "text/html; charset=UTF-8");
				mailMessage.setFrom(senderAddress);
				mailMessage.addRecipient(RecipientType.TO, receiverAddress);
				mailMessage.setSubject(subject);
				mailMessage.setContent(content, "text/html; charset=UTF-8");
				mailMessage.setSentDate(new Date());
				
				//메일 전송
				Transport.send(mailMessage);
				
				//인증코드 입력 요청
				sendAuthCodeService authService = new sendAuthCodeService();
				boolean isRegistSuccess = authService.sendAuthCode(mem_email, authCode); 
				
				//코드 등록 성공 판별
				if(!isRegistSuccess) {
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("history.back()");
					out.println("</script>");
				} else {
					forward = new ActionForward();
					forward.setPath("FindPassForm.me");
					forward.setRedirect(false);
				}
				
			} catch (AddressException e) {
				e.printStackTrace();
				System.out.println("FindPassAuthAction 오류");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				System.out.println("FindPassAuthAction 오류");
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println("FindPassAuthAction 오류");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("FindPassAuthAction 오류");
			} 
		}
		
		return forward;
	}

}
