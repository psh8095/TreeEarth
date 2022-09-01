package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardModifyProService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardModifyProAction");
		
		ActionForward forward = null;
		
		// 파라미터 가져와서 변수에 저장
		FreeboardDTO board = new FreeboardDTO();
		board.setFree_idx(Integer.parseInt(request.getParameter("free_idx")));
		board.setFree_name(request.getParameter("free_name"));
		board.setFree_pass(request.getParameter("free_pass"));
		board.setFree_subject(request.getParameter("free_subject"));
		board.setFree_content(request.getParameter("free_content"));
		System.out.println(board);
		
		// 게시물 수정 권한 판별을 위해 전달받은 파라미터 중 패스워드 비교
		// => FreeBoardModifyProService 의 isFreeBoardWriter() 메서드를 호출
		//    파라미터 : 글번호, 패스워드    리턴타입 : boolean(isFreeBoardWriter)
		// => 작업 내용은 BoardDeleteProService 의 isFreeBoardWriter() 와 동일
		FreeBoardModifyProService service = new FreeBoardModifyProService();
		boolean isFreeBoardWriter = service.isFreeBoardWriter(board.getFree_idx(), board.getFree_pass());
		
		// 수정 가능 여부 판별(isFreeBoardWriter 변수값 판별)
		// => 패스워드가 일치하지 않았을 경우(= isFreeBoardWriter 가 false)
		//    자바스크립트를 사용하여 "수정 권한 없음" 출력 후 이전페이지로 돌아가기
		// => 아니면, "수정 권한 있음" 출력
		if(!isFreeBoardWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한 없음!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 패스워드가 일치할 경우
			// FreeBoardModifyProService 의 modifyFreeBoard() 메서드 호출하여 글수정 작업 요청
			// => 파라미터 : FreeBoardDTO 객체    리턴타입 : boolean(isModifySuccess)
			boolean isModifySuccess = service.modifyFreeBoard(board);
			
			// 글 수정 작업 결과 판별
			// 실패 시 자바스크립트를 사용하여 "글 수정 실패!" 출력 후 이전페이지로 돌아가기
			// 성공 시 ActionForward 객체 생성하여 FreeBoardDetail.cm 페이지 요청
			// => 파라미터 : 글번호, 페이지번호
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("FreeBoardDetail.cm?free_idx=" + board.getFree_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}






