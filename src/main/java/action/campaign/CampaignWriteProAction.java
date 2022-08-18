package action.campaign;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import action.*;
import svc.campaign.*;
import vo.*;
import vo.campaign.*;

public class CampaignWriteProAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws 
Exception {
			System.out.println("CampaignWriteProAction");
			
			ActionForward forward = null;
			
			//업로드 파일 위치
			String uploadPath = "upload"; 
			
			//업로드 파일 크기 제한(10MB)
			int fileSize = 1024 * 1024 * 10; 
			
			//현재 서블릿 처리하는 서블릿 컨텍스트 객체 얻어오기
			ServletContext context = request.getServletContext();
			
			//실제 경로
			String realPath = context.getRealPath(uploadPath); 
//			System.out.println(realPath);
			
			//파일 업로드에 필요한 파라미터
			MultipartRequest multi = new MultipartRequest(
				request, 
				realPath, 
				fileSize, 
				"UTF-8", 
				new DefaultFileRenamePolicy()
			);
			
			String cam_id = multi.getParameter("cam_id");
			String cam_subject = multi.getParameter("cam_subject");
			String cam_content = multi.getParameter("cam_content");
			String cam_img = multi.getParameter("cam_img");
			String cam_original_img = multi.getParameter("cam_original_img");
			
			CampaignDTO campaign = new CampaignDTO();
			campaign.setCam_subject(cam_subject);
			campaign.setCam_content(cam_content);
			campaign.setCam_img(cam_img);
			campaign.setCam_original_img(cam_original_img);
			
//			System.out.println(campaign);
			
			//글쓰기 작업 요청
			CampaignWriteProSerive service = new CampaignWriteProSerive();
			boolean isWriteSuccess = service.registBoard(campaign);
			
			// Service 클래스로부터 글쓰기 작업 요청 처리 결과를 전달받아 성공/실패 여부 판별
			if(!isWriteSuccess) {// 글쓰기 실패 시
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('글쓰기 실패')");
					out.println("history.back()");
					out.println("</script>");
			} else {// 글쓰기 성공 시
					forward = new ActionForward();
					forward.setPath("CampaignList.cp");
					forward.setRedirect(true);
			}

			return forward;
	}
}
