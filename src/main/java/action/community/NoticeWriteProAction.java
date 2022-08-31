package action.community;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.community.NoticeWriteProService;
import vo.ActionForward;
import vo.community.NoticeDTO;

public class NoticeWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
System.out.println("NoticeWriteProAction");
		
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
		
		String no_id = multi.getParameter("no_id");
		String no_subject = multi.getParameter("no_subject");
		String no_content = multi.getParameter("no_content");
		String no_img = multi.getOriginalFileName("no_img");
		
		//폼에서 받아온 데이터 DTO에 저장
		NoticeDTO notice = new NoticeDTO();
		notice.setNo_id(no_id);
		notice.setNo_subject(no_subject);
		notice.setNo_content(no_content);
		notice.setNo_img(no_img);
		
//		System.out.println(notice);
		
		//글쓰기 작업 요청
		NoticeWriteProService service = new NoticeWriteProService();
		boolean isWriteSuccess = service.registBoard(notice);
		
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
			forward.setPath("NoticeList.cm");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
