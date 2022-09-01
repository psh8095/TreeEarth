package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardBlockProService;
import vo.ActionForward;
import vo.community.FreeBoardBlockDTO;

public class FreeBoardBlockProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardBlockProAction");
		
		ActionForward forward = null;
		
		int free_block_ref = Integer.parseInt(request.getParameter("free_idx"));
		String free_block_id = request.getParameter("free_block_id");
		String free_block_reason = request.getParameter("free_block_reason");

		//받아온 데이터 DTO에 저장
		FreeBoardBlockDTO free_block = new FreeBoardBlockDTO();
		free_block.setFree_block_ref(free_block_ref);
		free_block.setFree_block_id(free_block_id);
		free_block.setFree_block_reason(free_block_reason);
		
		//신고하기 작업 요청
		FreeBoardBlockProService service = new FreeBoardBlockProService();
		boolean isBlockSuccess = service.registBlock(free_block);
		
		//신고 작업 결과 확인
		if(!isBlockSuccess) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('신고 실패!')");
			out.println("window.close()");
			out.println("</script>");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('신고 완료!')");
			out.println("window.close()");
			out.println("</script>");
		}
		
		return forward;
	}

}