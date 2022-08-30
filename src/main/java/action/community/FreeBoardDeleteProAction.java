package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardDeleteProService;
import vo.ActionForward;

public class FreeBoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int free_idx = Integer.parseInt(request.getParameter("free_idx"));
		String free_pass = request.getParameter("free_pass");
		
		FreeBoardDeleteProService service = new FreeBoardDeleteProService();
		boolean isFreeBoardWriter = service.isFreeBoardWriter(free_idx, free_pass);
		
		if(!isFreeBoardWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			boolean isDeleteSuccess = service.removeBoard(free_idx);
			
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// 글목록(FreeBoardList.cm) 페이지 요청 => 페이지번호 전달
				forward = new ActionForward();
				forward.setPath("FreeBoardList.cm?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}








