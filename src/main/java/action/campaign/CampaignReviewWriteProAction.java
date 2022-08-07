package action.campaign;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class CampaignReviewWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		//파일 관련 정보
		String uploadPath = "upload"; 
		
		int fileSize = 1024 * 1024 * 10; 
		
		ServletContext context = request.getServletContext();
		
		String realPath = context.getRealPath(uploadPath); 
		
		//파일 업로드에 필요한 파라미터
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			fileSize, 
			"UTF-8", 
			new DefaultFileRenamePolicy()
		);
		
		String id = multi.getParameter("cam_re_id");
		String subject = multi.getParameter("cam_re_subject");
		String content = multi.getParameter("cam_re_content");
		String file = multi.getOriginalFileName("cam_re_file");
		String real_file = multi.getFilesystemName("cam_re_file");
		
		//폼에서 받아온 데이터 DTO에 저장
		CampaignReviewDTO cam_re = new CampaignReviewDTO();
		cam_re.setCam_re_id("cam_re_id");
		cam_re.setCam_re_subject("cam_re_subject");
		cam_re.setCam_re_content("cam_re_content");
		cam_re.setCam_re_file("cam_re_file");
		cam_re.setCam_re_real_file("cam_re_real_file");
		
		//글쓰기 작업 요청
		CampaignReviewWriteProService service = new CampaignReviewWriteProService();
		boolean isWriteSuccess = service.registBoard(cam_re);
		
		//글쓰기 작업 결과 확인
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 쓰기 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("CampaignReviewList.cm");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
