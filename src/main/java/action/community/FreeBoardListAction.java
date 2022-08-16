package action.community;

import java.util.ArrayList;

import javax.servlet.http.*;

import action.Action;
import svc.*;
import svc.community.FreeBoardListService;
import vo.*;
import vo.community.FreeboardDTO;

public class FreeBoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardListAction");
		
		ActionForward forward = null;
		
		// 페이징 처리를 위한 변수 선언
		int pageNum = 1; // 현재 페이지 번호(기본값 1 페이지로 설정)
		int listLimit = 10; // 한 페이지 당 표시할 게시물 수
		int pageLimit = 10; // 한 페이지 당 표시할 페이지 목록 수

		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // String -> int 변환
		}
		
		FreeBoardListService service = new FreeBoardListService();
		int listCount = service.getListCount();

		int maxPage = (int)Math.ceil((double)listCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, listCount);
		
		ArrayList<FreeboardDTO> boardList = service.getBoardList(pageNum, listLimit);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("boardList", boardList);
		
		forward = new ActionForward();
		forward.setPath("community/freeboard_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}



