package vo.member;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailSMTP extends Authenticator {
	
	// 인증 정보를 관리하는 클래스
	PasswordAuthentication passwordAuthentication;
	
	
	// 생성자 정의
	public MailSMTP() {
		
		// 인증에 사용할 아이디와 패스워드 입력(아이디, 패스워드) 
		passwordAuthentication = new PasswordAuthentication("gmp79333", "ralovvyqzsawyfnd");
		
	}

	// 인증정보를 외부로 리턴하기 위해 getPasswordAuthentication() 메서드 오버라이딩 
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return passwordAuthentication;
	}
	

}


