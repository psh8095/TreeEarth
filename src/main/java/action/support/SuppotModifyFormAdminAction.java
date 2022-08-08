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
		
		int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
		
		SupportDetailServiceAdmin service = new SupportDetailServiceAdmin();
		SupportDTO dto = service.getBoard(sup_idx);
		
		request.setAttribute("dto", dto);
		
		forward = new ActionForward();
		forward.setPath("support/support_board_modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
