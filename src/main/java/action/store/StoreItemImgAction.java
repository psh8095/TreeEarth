package action.store;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.store.StoreItemImgService;
import vo.ActionForward;
import vo.store.StoreDTO;

public class StoreItemImgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreItemImgAction");
		
		ActionForward forward = null;
		
		StoreItemImgService service = new StoreItemImgService();
		ArrayList<StoreDTO> itemimg = service.getItemImg();
		request.setAttribute("itemimg", itemimg);
		
		forward = new ActionForward();
		System.out.println("Action 돌아옴");
		forward.setPath("store/store_main.jsp");
		forward.setRedirect(false);
		
		return forward; 
	}

}
