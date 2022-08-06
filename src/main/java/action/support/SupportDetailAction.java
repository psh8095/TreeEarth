package action.support;

import javax.servlet.http.*;

import action.Action;
import svc.*;
import svc.support.SupportDetailServiceAdmin;
import vo.*;
import vo.support.SupportDTO;

public class SupportDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
		
		SupportDetailServiceAdmin service = new SupportDetailServiceAdmin();
		service.increaseReadCount(sup_idx);
		

		SupportDTO dto = new SupportDTO();
		
		request.setAttribute("dto", dto);
		
		forward = new ActionForward();
		forward.setPath("support/supprot_detail.jsp");
		forward.setRedirect(false);

		return forward;
		
	}
	
	

}
