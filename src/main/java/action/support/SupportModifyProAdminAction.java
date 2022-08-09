package action.support;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.support.SupportModifyProAdminService;
import vo.ActionForward;
import vo.support.SupportDTO;

public class SupportModifyProAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		String uploadPath = "upload";
		//파일 사이즈
		int filesize = 1024 * 1024 * 10;
		
		ServletContext context = request.getServletContext();
		
		String realPath = context.getRealPath(uploadPath);
		//업로드 파일이 실질적으로 저장되는 경로
		
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			filesize, 
			"UTF-8",
			new DefaultFileRenamePolicy()
		);
		
		
	//수정시 필요한 파라미터를 가져와 변수에 저장
		SupportDTO dto = new SupportDTO();
		dto.setSup_idx(Integer.parseInt(multi.getParameter("sup_idx")));
		dto.setSup_pass(multi.getParameter("sup_pass"));
		dto.setSup_goal_price(Integer.parseInt(multi.getParameter("sup_goal_price")));
		dto.setSup_subject(multi.getParameter("sup_subject"));
		dto.setSup_content(multi.getParameter("sup_content"));
		dto.setSup_thumbnail_file(multi.getOriginalFileName("sup_thumbnail_file"));
		dto.setSup_original_file(multi.getOriginalFileName("sup_original_file"));
		System.out.println(dto);

		//게시물 수정 권한 확인 위해 전달받은 파라미터 중 패스워드를 비교
		//SupportModifyProAdminService() 클래스의 isBoardWriter() 메서드를 호출
		//SupportDeleteProAdminService()의 isBoardWriter()와 작업 내용이 같다
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


