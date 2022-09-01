package action.community;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import action.Action;
import svc.community.FreeBoardReplyProService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardReplyProAction");
		
		ActionForward forward = null;
		
		FreeboardDTO board = new FreeboardDTO();
		board.setFree_idx(Integer.parseInt(request.getParameter("free_idx")));
		board.setFree_name(request.getParameter("free_name"));
		board.setFree_pass(request.getParameter("free_pass"));
		board.setFree_subject(request.getParameter("free_subject"));
		board.setFree_content(request.getParameter("free_content"));
		board.setFree_re_ref(Integer.parseInt(request.getParameter("free_re_ref")));
		board.setFree_re_lev(Integer.parseInt(request.getParameter("free_re_lev")));
		board.setFree_re_seq(Integer.parseInt(request.getParameter("free_re_seq")));
		
		// FreeBoardReplyProService 의 replyBaoard() 메서드를 호출하여 답글 등록 작업 요청
		// => 파라미터 : FreeBoardDTO 객체   리턴타입 : boolean(isReplySuccess)
		FreeBoardReplyProService service = new FreeBoardReplyProService();
		boolean isReplySuccess = service.replyBoard(board);
		
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
			forward.setPath("FreeBoardList.cm?pageNum=" + request.getParameter("pageNum"));
			forward.setRedirect(true);
		}
		
		return forward;
	}

}