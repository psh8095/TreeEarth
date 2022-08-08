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
import vo.ActionForward;

@WebServlet("*.st")
public class AdminStoreFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("adminStoreFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		Action action = null; // Action 클래스 인스턴스를 관리하는 변수
		ActionForward forward = null; // 포워딩 정보를 관리하는 변수
		
		if(command.equals("/AdminStoreWriteForm.st")) { // 상품 등록 페이지로 이동
			forward = new ActionForward();
			forward.setPath("store_admin_product/store_write.jsp"); 
			forward.setRedirect(false);
		} else if (command.equals("/AdminStoreWritePro.st")) { // 상품 등록 기능
			try {
				action = new AdminStoreWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
			}
		} else if (command.equals("/AdminStoreList.st")) { // 등록한 상품 목록으로 이동
			forward = new ActionForward();
			forward.setPath("store_admin_product/store_list.jsp"); 
			forward.setRedirect(false);
		} else if (command.equals("/AdminStoreListPro.st")) { 
			try {
				action = new AdminStoreWriteProAction();
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
