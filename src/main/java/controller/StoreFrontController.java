package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

// 스토어 컨트롤러
@WebServlet("*.st")
public class StoreFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StoreFrontController");
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("서블릿 주소 : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("")) {
			
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				// 리다이렉트방식
				response.sendRedirect(forward.getPath());
			} else {
				// 디스패처 방식
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
