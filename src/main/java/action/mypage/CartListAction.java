package action.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import svc.mypage.CartListService;
import vo.ActionForward;
import vo.member.MemberDTO;
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
		
		// 결제를 위한 회원 1명의 정보 조회
		MemberInfoService infoService = new MemberInfoService();
		MemberDTO member = infoService.getMemberInfo(sId);
		
		request.setAttribute("cart", list);
		request.setAttribute("member", member);

		forward = new ActionForward();
		forward.setPath("mypage/cart.jsp");

		return forward;
	}

}
