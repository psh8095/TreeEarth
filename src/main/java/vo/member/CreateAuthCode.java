package vo.member;

import java.util.Random;

public class CreateAuthCode {
	private String authCode;
	
	
	// ---------------------------------------------------------------------------------

	
	//인증코드에 가용되는 문자
	private final char[] codeTable = {
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
			'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '!', '#'
	};
	
	
	// ---------------------------------------------------------------------------------

	
	//렌덤 인증 코드를 생성하는 메서드
	public String createAuthCode() {
		
	
		//문자열 결합 클래스
		StringBuffer buffer = new StringBuffer();

		
		//난수 생성 클래스 
		Random random = new Random();
		
		
		//인증 코드의 길이
		int codeLength = 8; 
		
		
		//코드 테이블의 인덱스 범위
		int tableLength = codeTable.length; 
		
		
		//코드 생성
		for(int i = 0; i < codeLength; i++) { 
			
			//코드 테이블의 범위 내의 난수 생성
			int randomNum = random.nextInt(tableLength); 
			
			//코드 테이블의 인덱스에서 
			//난수에 해당하는 문자를 버퍼에 추가 
			buffer.append(codeTable[randomNum]);
			
		}
		
		
	// ---------------------------------------------------------------------------------

		
		//완성된 인증번호
		authCode = buffer.toString();
		
		return authCode;
		
	
	}
	

	
}
