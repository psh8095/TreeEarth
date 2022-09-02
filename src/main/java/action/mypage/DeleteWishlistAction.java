package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.DeleteWishlistService;
import vo.ActionForward;

public class DeleteWishlistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteWishlistAction");
		ActionForward forward = null;
		
		// 파라미터 데이터 배열에 저장
		String[] sto_idx = request.getParameterValues("sto_idx");
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		DeleteWishlistService service = new DeleteWishlistService();
		
		// 상품 번호가 0 이면 위시리스트 전체 삭제, 아니면 상품 번호에 해당하는 아이템 삭제
		for(int i = 0; i < sto_idx.length; i++) {
			if(Integer.parseInt(sto_idx[i]) == 0) {
				service.deleteWishlist(sId);
			} else {
				service.deleteWishlist(Integer.parseInt(sto_idx[i]), sId);
			}
		}
		
		forward = new ActionForward();
		
		forward.setPath("Wishlist.my");
		forward.setRedirect(true);
		return forward;
	}

}
