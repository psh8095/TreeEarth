package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.InsertWishlistService;
import vo.ActionForward;

public class InsertWishlistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertWishlistAction");
		ActionForward forward = null;
		
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		InsertWishlistService service = new InsertWishlistService();
		service.insertWishlist(sto_idx, sId);
		
		return forward;
	}

}
