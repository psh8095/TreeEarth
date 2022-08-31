package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.NoticeModifyProService;
import vo.ActionForward;
import vo.community.NoticeDTO;

public class NoticeModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int no_idx = Integer.parseInt(request.getParameter("no_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		NoticeDTO notice = new NoticeDTO();
		notice.setNo_idx(Integer.parseInt(request.getParameter("no_idx")));
		notice.setNo_id(request.getParameter("no_id"));
		notice.setNo_subject(request.getParameter("no_subject"));
		notice.setNo_content(request.getParameter("no_content"));
		
		//게시물 수정 권한 판별 요청
		NoticeModifyProService service = new NoticeModifyProService();
		boolean isNoticeWriter = service.isNoticeWriter(no_idx, mem_pass);
		
		if(!isNoticeWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한 없음!')");
			out.println("history.back()");
			out.println("</script>");
		} else { 
			//글 수정 작업 요청
			boolean isModifySuccess = service.modifyNotice(notice);
			
			//글 수정 작업 결과
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("NoticeDetail.cm?no_idx=" + notice.getNo_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}