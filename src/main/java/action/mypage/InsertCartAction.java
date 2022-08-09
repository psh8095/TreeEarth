package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.InsertCartService;
import vo.ActionForward;

public class InsertCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertCartAction");
		ActionForward forward = null;
		
		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
//		System.out.println(sto_idx + " " + sId);
		
		InsertCartService service = new InsertCartService();
		boolean isCart = service.insertCart(sto_idx, sId);
		
		
		return forward;
	}

}
