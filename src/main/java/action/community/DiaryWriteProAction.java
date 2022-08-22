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

public class DiaryWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3.DiaryWriteProAction");
		
		ActionForward forward = null;
		
		//사진 업로드 폴더
		String uploadPath = "img/community"; 
		
		//업로드 파일 크기 제한(10MB)
		int fileSize = 1024 * 1024 * 10; 
		
		//현재 서블릿 처리하는 서블릿 컨텍스트 객체 얻어오기
		ServletContext context = request.getServletContext();
		
		//실제 경로
		String realPath = context.getRealPath(uploadPath); 
		
		//파일 업로드에 필요한 파라미터
		MultipartRequest multi = new MultipartRequest(
			request, 
			realPath, 
			fileSize, 
			"UTF-8", 
			new DefaultFileRenamePolicy()
		);
		
		String diary_id = multi.getParameter("diary_id");
		String diary_subject = multi.getParameter("diary_subject");
		String diary_content = multi.getParameter("diary_content");
		String diary_img = multi.getOriginalFileName("diary_img");
		String diary_real_img = multi.getFilesystemName("diary_real_img");
		
		//폼에서 받아온 순서대로 데이터 DTO에 저장
		DiaryDTO diary = new DiaryDTO();
		diary.setDiary_id(diary_id);
		diary.setDiary_subject(diary_subject);
		diary.setDiary_content(diary_content);
		diary.setDiary_img(diary_img);
		diary.setDiary_real_img(diary_real_img);
		
//		System.out.println(diary);		
		
		//글쓰기 작업 요청
	DiaryWriteProService service = new DiaryWriteProService();
		boolean isWriteSuccess = service.registBoard(diary);
		
		//글쓰기 작업 결과 확인
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('글 쓰기 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			System.out.println("7.게시물 작성 성공");
			forward = new ActionForward();
			forward.setPath("DiaryList.cm");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
