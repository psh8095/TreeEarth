package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.CampaignExpiredListAction;
import action.CampaignRecruListAction;
import vo.ActionForward;

// 캠페인 컨트롤러
@WebServlet("*.cp")
public class CampaignFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CampaingFrontController");
		request.setCharacterEncoding("UTF-8");
		String command = request.getServletPath();
		System.out.println("서블릿 주소 : " + command);
		
		Action action = null;
		ActionForward forward = new ActionForward();
		
		if(command.equals("/CampaignRecruList.cp")) {
			// 모집중인 캠페인 서블릿 주소
			action = new CampaignRecruListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignExpiredList.cp")) {
			// 종료된 캠페인 서블릿 주소
			action = new CampaignExpiredListAction();
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
