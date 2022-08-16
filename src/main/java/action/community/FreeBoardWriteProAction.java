package action.community;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.community.FreeBoardWriteProService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null; // 포워딩 정보를 저장하는 변수 선언
		
		String uploadPath = "upload"; // 가상폴더명
		int fileSize = 1024 * 1024 * 10; // 파일크기지정
		
		ServletContext context = request.getServletContext(); // 현재 서블릿을 처리하는 객체인 서블릿컨텍스트 객체 가져오기
		
		String realPath = context.getContextPath(); // 업로드 파일이 저장되는 실제경로 얻어오기
		
		MultipartRequest multi = new MultipartRequest( // 파일업로드에 필요한 각종 파라미터 전달
			request,
			realPath,
			fileSize,
			new DefaultFileRenamePolicy()
		);
		
		// MultipartRequest 객체의 getParameter() 호출하여 폼 파라미터 가져와서 DTO 객체 borad에 저장
		FreeboardDTO board = new FreeboardDTO();
		board.setFree_name(multi.getParameter("free_name"));
		board.setFree_pass(multi.getParameter("free_pass"));
		board.setFree_subject(multi.getParameter("free_subject"));
		board.setFree_content(multi.getParameter("free_content"));
		board.setFree_img(multi.getParameter("free_img"));
		board.setFree_original_img(multi.getParameter("free_original_img"));
		
		// registFreeBoard() 메서드를 호출하여 글쓰기 작업 요청
		FreeBoardWriteProService service = new FreeBoardWriteProService();
		boolean isWriteSuccess = service.registFreeBoard(board); // 리턴타입 boolean(isWriteSuccess), 파라미터 FreeBoardDTO 객체(board)
		
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('글 쓰기 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("FreeBoardList.cm");
			forward.setRedirect(true);
		}

		return forward;
	
	}

}