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
		System.out.println("3. SupportWrite 액션");
		ActionForward forward = null;
		
		
	// ----------------------------------------------------------------------------------------
		
		//사진 업로드 폴더
		String uploadPath = "upload";
		//파일 사이즈
		int filesize = 1024 * 1024 * 10;
		
		ServletContext context = request.getServletContext();
		
		String realPath = context.getRealPath(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			filesize, 
			"UTF-8",
			new DefaultFileRenamePolicy()
		);
	
		
	// ----------------------------------------------------------------------------------------
	
		
		//dto 객체에 값 저장
		SupportDTO dto = new SupportDTO();
		
		dto.setSup_goal_price(Integer.parseInt(multi.getParameter("sup_goal_price")));
		dto.setSup_pass(multi.getParameter("sup_pass"));
		dto.setSup_subject(multi.getParameter("sup_subject"));
		dto.setSup_content(multi.getParameter("sup_content"));
		dto.setSup_thumbnail_real_file(multi.getFilesystemName("sup_thumbnail_file"));
		dto.setSup_thumbnail_file(multi.getOriginalFileName("sup_thumbnail_file"));
		dto.setSup_original_file(multi.getFilesystemName("sup_original_file"));
		dto.setSup_real_file(multi.getOriginalFileName("sup_original_file"));
		
		
	// ----------------------------------------------------------------------------------------

		
		//서비스 호출(데이터 입력)
		SupportWriteProAdminService service = new SupportWriteProAdminService();
		boolean isWriteSuccess = service.registSupport(dto);
		
	
	// ----------------------------------------------------------------------------------------

		//게시물 작성 여부 판별
		if(!isWriteSuccess) {
			System.out.println("7. 게시물 작성 실패");
			 response.setContentType("text/html; charset=UTF-8" ); //jsp에 있는 콘텐트타입 가져오기
			 PrintWriter out = response.getWriter();
			 out.println("<script>");
			 out.println("alert('글 쓰기 실패!')");
			 out.println("history.back()");
			 out.println("</script>");
			 
		} else {
			System.out.println("7. 게시물 작성 성공");
			forward = new ActionForward();
			forward.setPath("SupportList.su");
			forward.setRedirect(true);
		}
		
		
		return forward;
	}

}
