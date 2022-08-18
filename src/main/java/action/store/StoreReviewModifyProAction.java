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
		
//		int sto_re_idx = Integer.parseInt(request.getParameter("sto_re_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		StoreReviewDTO store_review = new StoreReviewDTO();
		store_review.setMem_id(request.getParameter("mem_id"));
		store_review.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store_review.setSto_re_idx(Integer.parseInt(request.getParameter("sto_re_idx")));
		store_review.setSto_re_content(request.getParameter("sto_re_content"));
		
		request.setAttribute("store_review", store_review);
		
		// 후기 수정 권한 판별 요청
		StoreReviewModifyProService service = new StoreReviewModifyProService();
		boolean isStoreReviewWrite = service.isStoreReviewWrite(store_review.getSto_re_idx(), mem_pass);
		
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


















