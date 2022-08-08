package action.support;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import action.Action;
import svc.support.SupportWriteProAdminService;
import vo.*;
import vo.support.SupportDTO;

public class SupportWriteProAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String uploadPath = "upload";

		int filesize = 1024 * 1024 * 10; //파일용량

		ServletContext context = request.getServletContext();

		String realPath = context.getRealPath(uploadPath);
		System.out.println(realPath);
		MultipartRequest multi = new MultipartRequest(request, realPath, filesize, "UTF-8",
				new DefaultFileRenamePolicy());
		
		SupportDTO dto = new SupportDTO();
		dto.setSup_goal_price(Integer.parseInt(multi.getParameter("sup_goal_price")));
		dto.setSup_now_total(Integer.parseInt(multi.getParameter("sup_now_total")));
		dto.setSup_total(Integer.parseInt(multi.getParameter("sup_total")));
		dto.setSup_money(Integer.parseInt(multi.getParameter("sup_money")));
		dto.setSup_idx(Integer.parseInt(multi.getParameter("sup_idx")));
		dto.setSup_pass(multi.getParameter("sup_pass"));
		dto.setSup_subject(multi.getParameter("sup_subject"));
		dto.setSup_content(multi.getParameter("sup_content"));
		dto.setSup_original_file(multi.getOriginalFileName("sup_original_file"));
		dto.setSup_thumbnail_file(multi.getOriginalFileName("sup_thumbnail_file"));
		
		
		SupportWriteProAdminService service = new SupportWriteProAdminService();
		boolean isWriteSuccess = service.registSupport(dto);
		
		if(!isWriteSuccess) {
			 response.setContentType("text/html; charset=UTF-8" ); //jsp에 있는 콘텐트타입 가져오기
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('글 쓰기 실패!')");
			 out.println("history.back()");
			 out.println("</script>");
			 
			} else {
				forward = new ActionForward();
				forward.setPath("SupportList.su");
				forward.setRedirect(true);
			}
		
		
		return forward;
	}

}
