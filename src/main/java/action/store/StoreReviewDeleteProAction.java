package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreReviewDeleteProService;
import vo.ActionForward;
import vo.store.StoreReviewDTO;

public class StoreReviewDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreReviewDeleteProAction");

		ActionForward forward = null;
		
		int sto_re_idx = Integer.parseInt(request.getParameter("sto_re_idx"));
		String mem_pass = request.getParameter("mem_pass");

		StoreReviewDTO store_review = new StoreReviewDTO();
		store_review.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store_review.setSto_re_idx(Integer.parseInt(request.getParameter("sto_re_idx")));
		System.out.println(store_review); // 확인용
		request.setAttribute("store_review", store_review);
		
		// 후기글 삭제 권한 판별 요청
		StoreReviewDeleteProService service = new StoreReviewDeleteProService();
		boolean isStoreReviewWrite = service.isStoreReviewWrite(sto_re_idx, mem_pass);
		
		if(!isStoreReviewWrite) { // 실패할 경우
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 아니면(패스워드 일치할 경우 = 권한 있을 경우)
			// 글 삭제 작업 요청
			boolean isReviewDeleteSuccess = service.deleteStoreReview(sto_re_idx);
			
			// 삭제 결과 판별
			if(!isReviewDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 삭제에 실패했습니다.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("StoreReviewList.st?sto_idx=" + store_review.getSto_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}
