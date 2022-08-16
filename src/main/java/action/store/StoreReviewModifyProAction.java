package action.store;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.store.StoreReviewModifyProService;
import vo.ActionForward;
import vo.store.StoreReviewDTO;

public class StoreReviewModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewModifyProAction");
		
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
		
		int sto_re_idx = Integer.parseInt(request.getParameter("sto_re_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		StoreReviewDTO store_review = new StoreReviewDTO();
		store_review.setMem_id(multi.getParameter("sto_re_mem_id"));
		store_review.setSto_idx(Integer.parseInt(multi.getParameter("sto_idx")));
		store_review.setSto_re_idx(Integer.parseInt(multi.getParameter("sto_re_idx")));
		store_review.setSto_re_content(multi.getParameter("sto_re_content"));
		store_review.setSto_re_file(multi.getOriginalFileName("sto_re_file"));
		store_review.setSto_re_real_file(multi.getFilesystemName("sto_re_file"));
		
		request.setAttribute("store_review", store_review);
		
		// 후기 수정 권한 판별 요청
		StoreReviewModifyProService service = new StoreReviewModifyProService();
		boolean isStoreReviewWrite = service.isStoreReviewWrite(sto_re_idx, mem_pass);
		
		if(!isStoreReviewWrite) { // 실패할 경우
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 글 수정 작업 요청
			boolean isReviewModifySuccess = service.modifyStoreReview(store_review);
			
			// 수정 작업 결과
			if(!isReviewModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정에 실패했습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("StoreReviewDetail.st?sto_idx=" + store_review.getSto_idx() + "&sto_re_idx=" + store_review.getSto_re_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}


















