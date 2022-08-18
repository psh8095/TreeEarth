package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaModifyProService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaModifyProAction");
		
		ActionForward forward = null;
		
		String mem_pass = request.getParameter("mem_pass"); // 회원 비밀번호 저장
		
		StoreQnaDTO store_qna = new StoreQnaDTO();
		store_qna.setMem_id(request.getParameter("mem_id"));
		store_qna.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store_qna.setSto_qna_idx(Integer.parseInt(request.getParameter("sto_qna_idx")));
		store_qna.setSto_qna_content(request.getParameter("sto_qna_content"));
		
		request.setAttribute("store_qna", store_qna);
		
		// 문의글 수정 권한 판별 요청
		StoreQnaModifyProService service = new StoreQnaModifyProService();
		boolean isStoreQnaWrite = service.isStoreQnaWrite(store_qna.getSto_qna_idx(), mem_pass);
		
		if(!isStoreQnaWrite) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한이 없습니다. 회원 로그인을 해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			// 글 수정 작업 요청
			boolean isQnaModifySuccess = service.modifyStoreQna(store_qna);
			
			// 수정 작업 결과
			if(!isQnaModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('문의글 수정에 실패하였습니다. 회원 로그인을 해주세요.')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("StoreQnaDetail.st?sto_idx=" + store_qna.getSto_idx() + "&sto_qna_idx=" + store_qna.getSto_qna_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}






















