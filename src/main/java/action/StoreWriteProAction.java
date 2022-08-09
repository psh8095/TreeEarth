package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.AdminStoreWriteProService;
import svc.FreeBoardWriteProService;
import vo.ActionForward;
import vo.StoreDTO;

public class AdminStoreWriteProAction implements Action {

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
		
		StoreDTO store = new StoreDTO();
		store.setSto_idx(Integer.parseInt(multi.getParameter("sto_idx")));
		store.setSto_thum_file(multi.getParameter("sto_thum_file"));
		store.setSto_thum_real_file(multi.getParameter("sto_thum_real_file"));
		store.setSto_subject(multi.getParameter("sto_subject"));
		store.setSto_price(Integer.parseInt(multi.getParameter("sto_price")));
		store.setSto_content(multi.getParameter("sto_content"));
		store.setSto_content_file(multi.getParameter("sto_content_file"));
		store.setSto_content_real_file(multi.getParameter("sto_content_real_file"));
		store.setSto_tag(multi.getParameter("sto_tag"));
		store.setSto_category(multi.getParameter("sto_category"));
		
		AdminStoreWriteProService service = new AdminStoreWriteProService();
		boolean isWriteSuccess = service.registStore(store); // 리턴타입 boolean(isWriteSuccess), 파라미터 FreeBoardDTO 객체(board)
		
		if(!isWriteSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('상품 등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("AdminStoreList.st");
			forward.setRedirect(true);
		}

		return forward;
	}

}
