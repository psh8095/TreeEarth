package action.member;


import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.member.JoinProService;
import vo.ActionForward;
import vo.member.MemberDTO;

public class joinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. join 액션");
		
		ActionForward forward = null;
		
		
	// ----------------------------------------------------------------------------------------
		
		
		//전송받은 값을 변수에 저장
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String address_detail = request.getParameter("address_detail");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		//저장된 값 확인
		System.out.println("id은 " + id);
		System.out.println("pass은 " + pass);
		System.out.println("name은 " + name);
		System.out.println("birth은 " + birth);
		System.out.println("gender은 " + gender);
		System.out.println("address은 " + address);
		System.out.println("address_detail은 " + address_detail);
		System.out.println("phone은" + phone);
		System.out.println("email은 " + email);
		
		
	// ----------------------------------------------------------------------------------------
	
		//성별 판별
//		if (gender.equals("1") || gender.equals("3")) {
//			gender = "남";
//		} else {
//			gender = "여";
//		}
		
		
	// ----------------------------------------------------------------------------------------
		
		//전화번호 형식 수정
		
		
	
	// ----------------------------------------------------------------------------------------
		
		//date 형식으로 변환
		Date dateBrith = Date.valueOf(birth);
		
		
		//dto 객체에 값 저장
		MemberDTO dto = new MemberDTO();
		dto.setMem_id(id);
		dto.setMem_pass(pass);
		dto.setMem_name(name);
		dto.setMem_birth(dateBrith);
		dto.setMem_gender(gender);
		dto.setMem_address(address);
		dto.setMem_address_detail(address_detail);
		dto.setMem_phone(phone);
		dto.setMem_email(email);
		
	
		
	// ----------------------------------------------------------------------------------------
	
		
		//서비스 호출
		JoinProService service = new JoinProService();
		boolean isJoinSuccess = service.joinMember(dto);

		
		//회원 가입 성공 판별
		if(!isJoinSuccess) {
			System.out.println("7. 회원가입 실패");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 가입에 실패하셨습니다.')");
			out.println("history.back()");
			out.println("</script>");
			
			
		} else {
			System.out.println("7. 회원가입 완료");
			forward = new ActionForward();
			forward.setPath("member/joinSuccess.jsp");
			forward.setRedirect(true);
		}
		
	
	// ----------------------------------------------------------------------------------------
	
		
		return forward;
	}

}
