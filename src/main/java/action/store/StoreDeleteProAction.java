package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreDeleteProService;
import vo.ActionForward;

public class StoreDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreDeleteProAction");
		
		ActionForward forward = null;
		
		// 전달받은 파라미터 가져오기(페이지번호 제외)
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		
		// StoreDeleteProService - isStoreWriter() 메서드를 호출하여 삭제 권한 판별 요청
		// => 파라미터 : 글번호, 패스워드    리턴타입 : boolean(isStoreWriter)
		StoreDeleteProService service = new StoreDeleteProService();
		boolean isStoreWriter = service.isStoreWriter(sto_idx);
		
		// 삭제 권한 판별 결과에 따른 작업 수행
		// 패스워드가 일치하지 않을 경우(= 권한 없을 경우)
		// 자바스크립트를 사용하여 "삭제 권한이 없습니다!" 출력 후 이전페이지로 돌아가기
		if(!isStoreWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 아니면(패스워드 일치할 경우 = 권한 있을 경우)
			// StoreDeleteProService - removeStore() 메서드를 호출하여 삭제 요청
			// => 파라미터 : 글번호    리턴타입 : boolean(isDeleteSuccess)
			// (StoreDAO - deleteStore())
			boolean isDeleteSuccess = service.removeStore(sto_idx);
			
			// 삭제 결과 판별
			// 삭제 실패 시 자바스크립트로 "삭제 실패!" 출력 후 이전페이지로 돌아가기
			if(!isDeleteSuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				// 글목록(BoardList.bo) 페이지 요청 => 페이지번호 전달
				forward = new ActionForward();
				forward.setPath("StoreList.st?pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}