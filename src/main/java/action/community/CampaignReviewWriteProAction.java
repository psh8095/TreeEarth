package action.community;

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
		System.out.println("CampaignReviewWriteProAction");
		
		ActionForward forward = null;
		
		//업로드 파일 위치
		String uploadPath = "img/community"; 
		
		//업로드 파일 크기 제한(10MB)
		int fileSize = 1024 * 1024 * 10; 
		
		//현재 서블릿 처리하는 서블릿 컨텍스트 객체 얻어오기
		ServletContext context = request.getServletContext();
		
		//실제 경로
		String realPath = context.getRealPath(uploadPath); 
//		System.out.println(realPath);
		
		//파일 업로드에 필요한 파라미터
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			fileSize, 
			"UTF-8", 
			new DefaultFileRenamePolicy()
		);
		
		String cam_re_id = multi.getParameter("cam_re_id");
		String cam_re_subject = multi.getParameter("cam_re_subject");
		String cam_re_content = multi.getParameter("cam_re_content");
		String cam_re_file = multi.getOriginalFileName("cam_re_file");
		String cam_re_real_file = multi.getFilesystemName("cam_re_file");
		
		//폼에서 받아온 데이터 DTO에 저장
		CampaignReviewDTO campaign_review = new CampaignReviewDTO();
		campaign_review.setCam_re_id(cam_re_id);
		campaign_review.setCam_re_subject(cam_re_subject);
		campaign_review.setCam_re_content(cam_re_content);
		campaign_review.setCam_re_file(cam_re_file);
		campaign_review.setCam_re_real_file(cam_re_real_file);
		
//		System.out.println(campaign_review);
		
		//글쓰기 작업 요청
		CampaignReviewWriteProService service = new CampaignReviewWriteProService();
		boolean isWriteSuccess = service.registBoard(campaign_review);
		
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
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
