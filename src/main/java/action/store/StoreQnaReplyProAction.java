package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaReplyProService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaReplyProAction");
		
		ActionForward forward = null;
		
		StoreQnaDTO store_qna = new StoreQnaDTO();
		store_qna.setMem_id(request.getParameter("mem_id"));
		store_qna.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store_qna.setSto_qna_idx(Integer.parseInt(request.getParameter("sto_qna_idx")));
		store_qna.setSto_qna_content(request.getParameter("sto_qna_content"));
		store_qna.setSto_qna_re_seq(Integer.parseInt(request.getParameter("sto_qna_re_seq")));
		store_qna.setSto_qna_re_ref(Integer.parseInt(request.getParameter("sto_qna_re_ref")));
		store_qna.setSto_qna_re_lev(Integer.parseInt(request.getParameter("sto_qna_re_lev")));
//		System.out.println(store_qna);
		
		// StoreQnaReplyProService 의 replyBoard() 메서드를 호출하여 답글 등록 작업 요청
		// => 파라미터 : StoreQnaDTO 객체   리턴타입 : boolean(isReplySuccess)
		StoreQnaReplyProService service = new StoreQnaReplyProService();
		boolean isReplySuccess = service.replyBoard(store_qna);
		
		// 답글 등록 작업 요청 처리 결과 판별
		// => 실패 시 자바스크립트를 사용하여 "답글 등록 실패!" 출력 후 이전페이지로 돌아가기
		//    성공 시 글목록으로 포워딩(파라미터로 페이지번호 전달)
		if(!isReplySuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 등록 실패!')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("StoreQnaList.st?pageNum=" + request.getParameter("pageNum"));
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
