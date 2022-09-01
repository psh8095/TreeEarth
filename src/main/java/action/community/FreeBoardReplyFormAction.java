package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardDetailService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		
		// 답글 작성에 필요한 글번호 파라미터 가져오기
		int free_idx = Integer.parseInt(request.getParameter("free_idx"));
		
		// 답글 작성에 필요한 게시물 상세 정보 조회를 위해
		// 기존에 정의된 FreeBoardDetailService 클래스의 getBoard() 메서드를 호출하여
		// 게시물 상세 정보를 리턴받아 freeboard_reply.jsp 페이지로 포워딩
		// => 단, 조회수 증가 작업은 수행하지 않음
		FreeBoardDetailService service = new FreeBoardDetailService();
		FreeboardDTO board = service.getBoard(free_idx);
		
		// 리턴받은 게시물 정보(BoardDTO 객체)를 request 객체에 저장
		request.setAttribute("board", board);
		
		// community 디렉토리의 freeboard_reply.jsp 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("community/freeboard_reply.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
