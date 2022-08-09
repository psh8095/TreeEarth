package action.store;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreModifyProService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreModifyProAction");
		
		ActionForward forward = null;
		
		// 파라미터 가져와서 변수에 저장
		StoreDTO store = new StoreDTO();
		store.setSto_idx(Integer.parseInt(request.getParameter("sto_idx")));
		store.setSto_subject(request.getParameter("sto_subject"));
		store.setSto_content(request.getParameter("sto_content"));
		
		// 게시물 수정 권한 판별을 위해 전달받은 파라미터 중 패스워드 비교
		// => StoreModifyProService 의 isStoreWriter() 메서드를 호출
		//    파라미터 : 글번호, 패스워드    리턴타입 : boolean(isStoreWriter)
		// => 작업 내용은 StoreDeleteProService 의 isStoreWriter() 와 동일
		StoreModifyProService service = new StoreModifyProService();
		boolean isStoreWriter = service.isStoreWriter(store.getSto_idx());
		
		// 수정 가능 여부 판별(isStoreWriter 변수값 판별)
		// => 패스워드가 일치하지 않았을 경우(= isStoreWriter 가 false)
		//    자바스크립트를 사용하여 "수정 권한 없음" 출력 후 이전페이지로 돌아가기
		// => 아니면, "수정 권한 있음" 출력
		if(!isStoreWriter) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 권한 없음!')");
			out.println("history.back()");
			out.println("</script>");
		} else { // 패스워드가 일치할 경우
			// StoreModifyProService 의 modifyStore() 메서드 호출하여 글수정 작업 요청
			// => 파라미터 : StoreDTO 객체    리턴타입 : boolean(isModifySuccess)
			boolean isModifySuccess = service.modifyStore(store);
			
			// 글 수정 작업 결과 판별
			// 실패 시 자바스크립트를 사용하여 "글 수정 실패!" 출력 후 이전페이지로 돌아가기
			// 성공 시 ActionForward 객체 생성하여 StoreItemDetail.st 페이지 요청
			// => 파라미터 : 글번호, 페이지번호
			if(!isModifySuccess) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setPath("StoreItemDetail.st?sto_idx=" + store.getSto_idx() + "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}