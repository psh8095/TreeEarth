package action.support;

import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.support.SupportModifyProAdminService;
import vo.ActionForward;
import vo.support.SupportDTO;

public class SupportModifyProAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		
	//수정할 때 필요한 요소들 정의
		SupportDTO dto = new SupportDTO();
		dto.setSup_idx(Integer.parseInt(request.getParameter("sup_idx")));
		dto.setSup_pass(request.getParameter("sup_pass"));
		dto.setSup_goal_price(Integer.parseInt(request.getParameter("sup_goal_price")));
		dto.setSup_total(Integer.parseInt(request.getParameter("sup_total")));
		dto.setSup_subject(request.getParameter("sup_subject"));
		dto.setSup_content(request.getParameter("sup_content"));
		dto.setSup_money(Integer.parseInt(request.getParameter("sup_money")));

		SupportModifyProAdminService service = new SupportModifyProAdminService();
		boolean isBoardWriter = service.isBoardWriter(dto.getSup_idx(), dto.getSup_pass());
		if(!isBoardWriter) {
			 response.setContentType("text/html; charset=UTF-8" );
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('수정 권한 없음')");
			 out.println("history.back()");
			 out.println("</script>");
		}else{
			boolean isModifySuccess = service.modifySupportBoard(dto);
			if(!isModifySuccess) {
			response.setContentType("text/html; charset=UTF-8" );
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('글 수정 실패!')");
			 out.println("history.back()");
			 out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setPath("SupportDetail.su?sup_idx=" + dto.getSup_idx());
				//무한스크롤 방식이래서 일단은 페이지 번호 첨부 안함
				forward.setRedirect(true);
			}
		}
		
		return forward;
		}
	}


