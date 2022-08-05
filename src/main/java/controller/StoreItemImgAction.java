package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;
import vo.StoreDTO;

public class StoreItemImgAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("StoreItemImgAction");
		
		ActionForward forward = null;
		
		StoreItemImgService service = new StoreItemImgService();
		ArrayList<StoreDTO> itemimg = service.getItemImg();
		
		return forward; 
	}

}
