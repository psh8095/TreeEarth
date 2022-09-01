package action.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.OrderListService;
import vo.ActionForward;
import vo.mypage.OrderListDTO;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderListAction");
		ActionForward forward = null;
		
		// 주문 정보 조회를 위한 세션값(mem_id) 저장
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		// order_list.jsp 에서 출력하기 위해 request 객체에 저장할 리스트들 선언
		OrderListService service = new OrderListService();
		List<OrderListDTO> orderList = service.getOrderInfo(sId);
		
		// 저장한 데이터 request 객체에 저장
		request.setAttribute("orderList", orderList);
		
		forward = new ActionForward();
		forward.setPath("mypage/order_list.jsp");
		return forward;
	}

}
