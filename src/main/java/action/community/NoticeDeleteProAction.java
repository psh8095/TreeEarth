package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.NoticeDeleteProService;
import vo.ActionForward;

public class NoticeDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int no_idx = Integer.parseInt(request.getParameter("no_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		//삭제 권한 판별 요청
		NoticeDeleteProService service = new NoticeDeleteProService();
		boolean isNoticeWriter = service.isNoticeWriter(no_idx, mem_pass);
		
		if(!isNoticeWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 아니면(패스워드 일치할 경우 = 권한 있을 경우)
			// NoticeDeleteProService - deleteNotice() 메서드를 호출하여 삭제 요청
			// => 파라미터 : 글번호    리턴타입 : boolean(isDeleteSuccess)
			// (NoticeDAO - deleteNotice())
			boolean isDeleteSuccess = service.deleteNotice(no_idx);
			
			// 삭제 결과 판별
			// 삭제 실패 시 자바스크립트로 "삭제 실패!" 출력 후 이전페이지로 돌아가기
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// 글목록(NoticeList.bo) 페이지 요청 => 페이지번호 전달
				forward = new ActionForward();
				forward.setPath("NoticeList.cm?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}

