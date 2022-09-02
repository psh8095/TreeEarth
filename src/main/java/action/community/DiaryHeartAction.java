package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.community.DiaryHeartService;
import vo.ActionForward;
import vo.community.DiaryDTO;

public class DiaryHeartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DiaryHeartAction");
		ActionForward forward = null;
		
		int diaryno = Integer.parseInt(request.getParameter("diaryno"));
		HttpSession session = request.getSession();
		String mid = session.getAttribute("sId").toString();

		DiaryDTO diary = new DiaryDTO();
		int likecnt = diary.getDiary_likecnt();
		
		DiaryHeartService service = new DiaryHeartService();
		int updateLike = service.updateLike(diaryno, mid);
		
		int updateDiary = service.updateDiary(diaryno, updateLike, likecnt);
		likecnt += likecnt;
		
		diary = new DiaryDTO();
		diary.setDiary_likecnt(likecnt);
		
		System.out.println(likecnt);
		System.out.println("업데이트라이쿠ㅡ" +updateLike + "업데이트다요리" +updateDiary);
		
		return forward;
	}

}
