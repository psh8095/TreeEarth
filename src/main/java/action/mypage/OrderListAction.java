package action.mypage;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.mypage.OrderListService;
import svc.store.StoreItemDetailService;
import vo.ActionForward;
import vo.mypage.OrderDTO;
import vo.mypage.OrderDetailDTO;
import vo.store.StoreDTO;

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
		List<OrderDTO> orderList = service.getOrderInfo(sId);
		List<OrderDetailDTO> orderDetail = new ArrayList<OrderDetailDTO>();
		List<StoreDTO> store = new ArrayList<StoreDTO>();
		
		StoreItemDetailService stoService = new StoreItemDetailService();
		
		// 반복문을 사용해 주문번호에 해당하는 주문상세정보와 상품정보를 리스트 객체에 추가
		for(int i = 0; i < orderList.size(); i++) {
			orderDetail.add(service.getOrderDetail(orderList.get(i).getOrder_id()));
			store.add(stoService.getItemDetail(orderDetail.get(i).getSto_idx()));
		}
		
		// 저장한 데이터들 request 객체에 저장
		request.setAttribute("orderList", orderList);
		request.setAttribute("orderDetail", orderDetail);
		request.setAttribute("store", store);
		
		forward = new ActionForward();
		forward.setPath("mypage/order_list.jsp");
		return forward;
	}

}
