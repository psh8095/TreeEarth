package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class DiaryBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3.DiaryBoardDetailAction");
		ActionForward forward = null;
		
		//성장일지 글번호 가져오기
		int diary_idx = Integer.parseInt(request.getParameter("diary_idx"));
		
		//조회수 증가 요청
		DiaryDetailService service = new DiaryDetailService();
		service.increaseReadcount(diary_idx);
		
		//상세내용 조회 요청
		DiaryDTO diary = service.getDiaryDetail(diary_idx);
		
		request.setAttribute("diary", diary);

		forward = new ActionForward();
		forward.setPath("community/diary_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
