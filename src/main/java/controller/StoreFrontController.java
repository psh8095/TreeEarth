package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminStoreWriteProAction;
import action.StoreItemListAction;
import vo.ActionForward;

@WebServlet("*.st")
public class adminStoreFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adminStoreFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		Action action = null; // Action 클래스 인스턴스를 관리하는 변수
		ActionForward forward = null; // 포워딩 정보를 관리하는 변수
		
		if(command.equals("/AdminStoreWriteForm.st")) { // 상품글 등록 페이지로 이동
			forward = new ActionForward();
			forward.setPath("store_admin_product/store_write.jsp"); 
			forward.setRedirect(false);
		} else if (command.equals("/AdminStoreWritePro.st")) {
			try {
				action = new AdminStoreWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		} else if (command.equals("/AdminStoreList.st")) { // 등록한 상품글 목록으로 이동
//			try {
//				action = new AdminStoreListAction();
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if (command.equals("/AdminStoreDetail.st")) { // 등록한 상품글 상세페이지로 이동
//			try {
//				action = new AdminStoreDetailAction();
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/AdminStoreDeleteForm.bo")) { // 등록한 상품글 삭제
//			forward = new ActionForward();
//			forward.setPath("store_admin_product/store_delete.jsp");
//			forward.setRedirect(false); // Dispatcher 방식(생략 가능)
//		} else if(command.equals("/AdminStoreDeletePro.bo")) {
//			action = new AdminStoreDeleteProAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/AdminStoreModifyForm.bo")) { // 등록한 상품글 수정
//			action = new AdminStoreModifyFormAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/AdminStoreModifyPro.bo")) {
//			action = new AdminStoreModifyProAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		} else if (command.equals("/StoreItemList.st")) {
			action = new StoreItemListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
