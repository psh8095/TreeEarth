package action.support;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.support.SupportDetailServiceAdmin;
import vo.ActionForward;
import vo.support.SupportDTO;

public class SuppotModifyFormAdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("3. SuppotModifyFormAdminAction");
		
		// 글 수정에 필요한 글번호 파라미터 가져오기
		int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
		
		//글 수정에 필요한 게시물 상세 정보 조회
		//SupportDetailServiceAdmin 클래스의 getBoard() 메서드 호출
		//게시물 상세 정보를 리턴 받고 support_board_modify.jsp 페이지로 포워딩
		// 이때 수정 작업이므로 조회수 증가는 행하지 않음
		SupportDetailServiceAdmin service = new SupportDetailServiceAdmin();
		SupportDTO dto = service.getBoard(sup_idx);
		
		request.setAttribute("dto", dto);
		
		System.out.println("7. ModifyForm 확인");
		forward = new ActionForward();
		forward.setPath("support/support_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
