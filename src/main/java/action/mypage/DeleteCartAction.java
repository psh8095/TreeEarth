package action.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.DeleteCartService;
import vo.ActionForward;

public class DeleteCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteCartAction");
		ActionForward forward = null;
		
		// 파라미터 데이터 배열에 저장
		String[] sto_idx = request.getParameterValues("sto_idx");
		
//		int sto_idx = Integer.parseInt(request.getParameter("sto_idx"));
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
//		System.out.println(sto_idx + " " + sId);
		
		DeleteCartService service = new DeleteCartService();
		
		// 상품 번호가 0 이면 장바구니 전체 삭제, 아니면 상품 번호에 해당하는 아이템 삭제
		for(int i = 0; i < sto_idx.length; i++) {
			if(Integer.parseInt(sto_idx[i]) == 0) {
				service.deleteCart(sId);
			} else {
				service.deleteCart(Integer.parseInt(sto_idx[i]), sId);
			}
		}
		
		forward = new ActionForward();
		
		forward.setPath("Cart.my");
		forward.setRedirect(true);
		return forward;
	}

}
