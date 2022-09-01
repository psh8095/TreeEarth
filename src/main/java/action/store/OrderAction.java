package action.store;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.member.MemberInfoService;
import svc.store.insertOrderService;
import svc.store.StoreItemDetailService;
import vo.ActionForward;
import vo.member.MemberDTO;
import vo.mypage.OrderDTO;
import vo.store.StoreDTO;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("OrderAction");
		ActionForward forward = null;
		
		HttpSession session = request.getSession();
		String sId = session.getAttribute("sId").toString();
		
		String[] sto_idx = request.getParameterValues("sto_idx");
		List<StoreDTO> storeList = new ArrayList<StoreDTO>();
		StoreItemDetailService service = new StoreItemDetailService();
		
		for(int i = 0; i < sto_idx.length; i++) {
			StoreDTO store = service.getItemDetail(Integer.parseInt(sto_idx[i]));
			storeList.add(store);
		}
		
		// 결제를 위한 회원 1명의 정보 조회
		MemberInfoService infoService = new MemberInfoService();
		MemberDTO member = infoService.getMemberInfo(sId);
		
		request.setAttribute("storeList", storeList);
		request.setAttribute("member", member);
		
		forward = new ActionForward();
		forward.setPath("store/order.jsp");
		return forward;
	}

}
