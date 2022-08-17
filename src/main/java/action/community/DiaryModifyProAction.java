package action.community;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class DiaryModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3.DiaryModifyProAction");
		ActionForward forward = null;
		
		
		int diary_idx = Integer.parseInt(request.getParameter("diary_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		DiaryDTO diary = new DiaryDTO();
		diary.setDiary_idx(Integer.parseInt(request.getParameter("diary_idx")));
		diary.setDiary_id(request.getParameter("diary_id"));
		diary.setDiary_subject(request.getParameter("diary_subject"));
		diary.setDiary_content(request.getParameter("diary_content"));
		
		//게시물 수정 권한 판별 요청
		DiaryModifyProService service = new DiaryModifyProService();
		boolean isDiaryWriter = service.isDiaryWriter(diary_idx, mem_pass);
		
		if(!isDiaryWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한 없음!')");
			out.println("history.back()");
			out.println("</script>");
		} else { 
			//글 수정 작업 요청
			boolean isModifySuccess = service.modifyDiary(diary);
			
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
				forward.setPath("DiaryList.cm?diary_idx=" + diary.getDiary_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
