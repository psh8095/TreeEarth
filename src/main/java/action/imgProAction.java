package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.imgProservice;
import vo.ActionForward;
import vo.ImgDTO;

public class imgProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3 - 액션");
		ActionForward forward = null;
		
		String uploadPath = "upload"; 
		
		int fileSize = 1024 * 1024 * 10; 
		
		ServletContext context = request.getServletContext();
		
		String realPath = context.getRealPath(uploadPath); 
		
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			fileSize, 
			"UTF-8", 
			new DefaultFileRenamePolicy()
		);
		
		// -----------------------------------------------------------------------
		
		
		//폼에서 받아온 데이터 dto에 저장
		String name = multi.getParameter("board_name");
		String subjec = multi.getParameter("board_subject");
		String content = multi.getParameter("board_content");
		String file = multi.getOriginalFileName("board_file");
		String real_file = multi.getFilesystemName("board_file");
		
		ImgDTO dto = new ImgDTO();
		dto.setBoard_Name(name);
		dto.setBoard_subject(subjec);
		dto.setBoard_content(content);
		dto.setBoard_file(file);
		dto.setBoard_real_file(real_file);
		
		
		//사진 파일 이름
		System.out.println("3.1 - 사진 파일 이름 = "+file);
		
		
		
		// ----------------------------------------------------------------------------------------

		
		imgProservice service = new imgProservice();
		boolean isWriteSuccess = service.registBoard(dto);
		
		
		// ----------------------------------------------------------------------------------------

		
		
		//포워딩 판별 코드
		if(!isWriteSuccess) { 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 쓰기 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else { 
			System.out.println("7 - 액션 돌아왔다");
			forward = new ActionForward();
			forward.setPath("./");
			forward.setRedirect(false);
		}
		
		
		// ----------------------------------------------------------------------------------------

		
		return forward;
	}

}
