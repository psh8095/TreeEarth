package action.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.CartListService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class CartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartListAction");
		ActionForward forward = null;

		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		CartListService service = new CartListService();
		List<StoreDTO> list = service.selectCartList(sId);

		forward = new ActionForward();
		forward.setPath("mypage/cart.jsp");
		return forward;
	}

}
