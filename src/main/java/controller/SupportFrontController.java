package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ac.*;
import vo.*;

@WebServlet("*.su")
public class SupportFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("SupportFrontController");
		request.setCharacterEncoding("UTF-8");

		String command = request.getServletPath();
		System.out.println("command : " + command);

		Action action = null;
		ActionForward forward = null;

		if (command.equals("/SupportDetail.su")) {
			// 후원 페이지 주소 요청 시 수행
			try {
				action = new SupportDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("detail 오류 챱");
				e.printStackTrace();
			}
		} else if (command.equals("/SupportWriteFormAdmin.su")) {
			forward = new ActionForward();
			forward.setPath("support/support_write_admin.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/SupportWriteProAdmin.su")) {
			try {
				action = new SupportWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("writepro 오류 챱");
				e.printStackTrace();
			}
			//글쓰기 이동
		} else if (command.equals("/SupportModifyAdmin.su")) {
			// 후원 수정 요청 시 수행
			try {
				action = new SuppotModifyFormAdminAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("modifyform 오류 챱");
				e.printStackTrace();
			}
		} else if (command.equals("/SupportModifyProAdmin.su")) {
			try {
				action = new SupportModifyProAdminAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("modifypro 오류 챱");
				e.printStackTrace();
			}

		} else if (command.equals("/SupportDeleteFormAdmin.su")) {
			forward = new ActionForward();
			forward.setPath("support/support_delete_form.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/SupportDeleteProAdmin.su")) {
			try {
				action = new SupportDeleteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("deletepro 오류 챱");
				e.printStackTrace();
			}

		}

		if (forward != null) {
			if (forward.isRedirect()) { // 파라미터 초기화 해서 들고 감
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		} //

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
