package action.store;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreQnaWriteProService;
import vo.ActionForward;
import vo.store.StoreQnaDTO;

public class StoreQnaWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreQnaWriteProAction");
		
		ActionForward forward = null;
		
		// 폼 파라미터 데이터 StoreQnaDTO 객체에 저장
		StoreQnaDTO storeQna = new StoreQnaDTO();
		storeQna.setMem_id(request.getParameter("mem_id"));
		storeQna.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		storeQna.setSto_qna_content(request.getParameter("sto_qna_content"));
		System.out.println(storeQna); // 확인용
		
		// 상품 문의 글쓰기 작업 요청
		StoreQnaWriteProService service = new StoreQnaWriteProService();
		boolean isWriteQnaSuccess = service.getStoreQna(storeQna);
		
		// 글쓰기 작업 결과 확인
		if(!isWriteQnaSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('상품 문의 작성에 실패하였습니다.')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setPath("StoreQnaList.st?sto_idx=" + storeQna.getSto_idx());
			forward.setRedirect(true); // 리다이렉트 방식
		}
		
		return forward;
	}

}
