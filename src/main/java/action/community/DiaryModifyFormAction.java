package action.community;

import javax.servlet.http.*;

import action.*;
import svc.community.*;
import vo.*;
import vo.community.*;

public class DiaryModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3.DiaryModifyFormAction");
		ActionForward forward = null;
		
		//수정할 글 번호 가져오기
		int diary_idx = Integer.parseInt(request.getParameter("diary_idx"));
		
		DiaryDetailService service = new DiaryDetailService();
		DiaryDTO diary = service.getDiaryDetail(diary_idx);
		
		request.setAttribute("diary", diary);
		
		forward = new ActionForward();
		forward.setPath("community/diary_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
