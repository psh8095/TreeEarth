package action.store;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.store.StoreReviewWriteProService;
import vo.ActionForward;
import vo.store.StoreReviewDTO;

public class StoreReviewWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewWriteProAction");
		
		ActionForward forward = null;
		
		// 상품 후기 사진 업로드 파일 경로
		String uploadPath = "upload";
		
		// 파일 크기 제한 -> 10MB
		int fileSize = 1024 * 1024 * 10;
		// 현재 프로젝트(서블릿)를 처리하는 객체인 서블릿 컨텍스트 객체 얻어오기
		ServletContext context = request.getServletContext();
		// 업로드 파일이 저장되는 실제 경로
		String realPath = context.getRealPath(uploadPath);
		System.out.println(realPath);
		
		// MultipartRequest 객체 생성 -> 파일 업로드에 필요한 각종 파라미터 전달
		MultipartRequest multi = new MultipartRequest(
				request, 
				realPath, 
				fileSize, 
				"UTF-8",
				new DefaultFileRenamePolicy()
				);
		
//		System.out.println(Integer.parseInt(request.getParameter("sto_re_idx")));
		
		// 폼 파라미터 데이터 store_reviewDTO 객체에 저장
		StoreReviewDTO storeReview = new StoreReviewDTO();
//		storeReview.setSto_re_idx(Integer.parseInt(multi.getParameter("sto_re_idx")));
		storeReview.setMem_id(multi.getParameter("sto_re_mem_id"));
		storeReview.setSto_idx(Integer.parseInt(multi.getParameter("sto_idx")));
		storeReview.setSto_re_score(Integer.parseInt(multi.getParameter("reviewStar")));
		storeReview.setSto_re_content(multi.getParameter("sto_re_content"));
		storeReview.setSto_re_file(multi.getOriginalFileName("sto_re_file")); // 원본 파일명
		storeReview.setSto_re_real_file(multi.getFilesystemName("sto_re_file")); // 실제 업로드 파일명
		System.out.println(Integer.parseInt(multi.getParameter("reviewStar")));
		
		System.out.println(storeReview.getSto_idx());
		
		// 상품 구매 후기 글쓰기 작업 요청
		StoreReviewWriteProService service = new StoreReviewWriteProService();
		boolean isWriteReviewSuccess = service.getStoreReview(storeReview);
		
		// 글쓰기 작업 결과 확인
		if(!isWriteReviewSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매 후기 작성에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("StoreReviewList.st?sto_idx=" + storeReview.getSto_idx());
			forward.setRedirect(true);
		}
		
		return forward;
	}

}















