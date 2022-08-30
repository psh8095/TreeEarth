package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardDetailService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardModifyFormAction");
		
		ActionForward forward = null;
		
		// 글 수정에 필요한 글번호 파라미터 가져오기
		int free_idx = Integer.parseInt(request.getParameter("free_idx"));
		
		// 글 수정에 필요한 게시물 상세 정보 조회를 위해
		// 기존에 정의된 FreeBoardDetailService 클래스의 getBoard() 메서드를 호출하여
		// 게시물 상세 정보를 리턴받아 freeboard_modify.jsp 페이지로 포워딩
		// => 단, 조회수 증가 작업은 수행하지 않음
		FreeBoardDetailService service = new FreeBoardDetailService();
		FreeboardDTO freeboard = service.getBoard(free_idx);
		
		// 리턴받은 게시물 정보(FreeBoardDTO 객체)를 request 객체에 저장
		request.setAttribute("freeboard", freeboard);
		
		// community 디렉토리의 freeboard_modify.jsp 페이지로 포워딩
		forward = new ActionForward();
		forward.setPath("community/freeboard_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}


