package action;

import javax.servlet.http.*;

import svc.*;
import vo.*;

public class FreeBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 페이징 처리를 위한 변수선언
		int pageNum = 1;
		int listLimit = 10;
		int pageLimit = 10;
		
		// pageNum 이 전달 됐을 경우 가져와서 변수에 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		// 페이징 처리에 필요한 전체 게시물 갯수 조회 작업 요청
		FreeBoardListService service = new FreeBoardListService();
		int listCount = service.getListCount();
		
		
		
		
		
		
		
		return forward;
	}

}
