package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaDeleteProService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaDeleteProAction");
		
		ActionForward forward = null;
		
		int sto_qna_idx = Integer.parseInt(request.getParameter("sto_qna_idx"));
		String mem_pass = request.getParameter("mem_pass");
		
		StoreQnaDTO store_qna = new StoreQnaDTO();
		store_qna.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store_qna.setSto_qna_idx(Integer.parseInt(request.getParameter("sto_qna_idx")));
		System.out.println(store_qna); // 확인용
		
		request.setAttribute("store_qna", store_qna);
		
		// 문의글 삭제 권한 판별 요청
		StoreQnaDeleteProService service = new StoreQnaDeleteProService();
		boolean isStoreQnaWrite = service.inStoreQnaWrite(sto_qna_idx, mem_pass);
		
		if(!isStoreQnaWrite) { // 실패할 경우
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 아니면(패스워드 일치할 경우 = 권한 있을 경우)
			// 글 삭제 작업 요청
			boolean isQnaDeleteSuccess = service.deleteStoreQna(sto_qna_idx);
			
			// 삭제 결과 판별
			if(!isQnaDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('문의글 삭제에 실패했습니다. 회원 로그인을 해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("StoreQnaList.st?sto_idx=" + store_qna.getSto_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}















