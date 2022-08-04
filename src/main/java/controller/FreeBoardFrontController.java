package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.FreeBoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.cm")
public class FreeBoardFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FreeBoardFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		
		Action action = null; // Action 클래스 인스턴스를 관리하는 변수
		ActionForward forward = null; // 포워딩 정보를 관리하는 변수
		
		if(command.equals("/FreeBoardWriteForm.cm")) {
			forward = new ActionForward();
			forward.setPath("freeboard/freeboard_write.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/FreeBoardWritePro.cm")) {
			try {
				action = new FreeBoardWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FreeBoardList.cm")) {
			try {
				action = new FreeBoardListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		} else if {
			
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}