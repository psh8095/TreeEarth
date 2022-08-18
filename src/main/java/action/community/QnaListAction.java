package action.community;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class QnaListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("QnaListAction");
		ActionForward forward = null;
		
		//페이징처리 변수
		int pageNum = 1; 
		int listLimit = 10;
		int pageLimit = 10; 

		//pageNum에 현재 페이지 번호 저장
		if(request.getParameter("pageNum") != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); 
		}
		
		String qna_tag = request.getParameter("qna_tag");
		
		QnaDTO qna = new QnaDTO();
		qna.setQna_tag(qna_tag);
		
		//전체 게시물 개수 조회 요청
		QnaListService service = new QnaListService();
		int itemlistCount = service.getListCount(qna_tag);
		System.out.println("listCount: " + itemlistCount);
		
		//페이징처리
		int maxPage = (int)Math.ceil((double)itemlistCount / listLimit);
		int startPage = ((int)((double)pageNum / pageLimit + 0.9) - 1) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;

		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(pageNum, maxPage, startPage, endPage, itemlistCount);
		
		//게시물 목록
		ArrayList<QnaDTO> qnaList = service.getQnaList(pageNum, listLimit, qna_tag);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("qnaList", qnaList);
		
		forward = new ActionForward();
		forward.setPath("QnaList.cm");
		forward.setRedirect(false);
		
		return forward;
	}

}
