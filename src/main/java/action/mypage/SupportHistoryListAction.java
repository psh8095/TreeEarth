package action.mypage;

import java.util.*;

import javax.servlet.http.*;

import action.*;
import svc.support.*;
import vo.*;
import vo.support.*;

public class SupportHistoryListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SupportHistoryListAction");
		
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String mem_id = session.getAttribute("sId").toString();
		
		MoneyHistoryService service = new MoneyHistoryService();
		//후원 내역 조회
		ArrayList<SupportHistoryDTO> supList = service.getSupportHistory(mem_id);
		
		//서비스 호출(리스트 조회)
		SupportListService Service = new SupportListService();
		ArrayList<SupportDTO> support = Service.getSupportList();
		
		//mem_id 의 후원 내역
		request.setAttribute("supList", supList);
		//후원 목록 조회
		request.setAttribute("support", support);
		
		forward = new ActionForward();
		forward.setPath("mypage/support_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
