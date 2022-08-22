package action.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.WishlistService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class WishlistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("WishlistAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		WishlistService service = new WishlistService();
		List<StoreDTO> wishlist = service.selectWishlist(sId);
		
		request.setAttribute("wishlist", wishlist);

		forward = new ActionForward();
		forward.setPath("mypage/wishlist.jsp");
		
		return forward;
	}

}
