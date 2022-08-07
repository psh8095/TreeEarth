package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import action.support.SupportDeleteProAdminAction;
import action.support.SupportDetailAction;
import action.support.SupportModifyProAdminAction;
import action.support.SupportWriteProAdminAction;
import action.support.SuppotModifyFormAdminAction;
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
			// 후원 상상세 보기 주소 요청 시 수행
			try {
				action = new SupportDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("detail 오류 챱");
				e.printStackTrace();
			}
		} else if (command.equals("/SupportWriteFormAdmin.su")) {
			//글쓰기 폼 작성
			forward = new ActionForward();
			forward.setPath("support//support_write_admin.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/SupportWriteProAdmin.su")) {
//			글쓰기 실제 수행
			try {
				action = new SupportWriteProAdminAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("writepro 오류 챱");
				e.printStackTrace();
			}
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
//			후원 수정 실제 액션
			try {
				action = new SupportModifyProAdminAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				System.out.println("modifypro 오류 챱");
				e.printStackTrace();
			}

		} else if (command.equals("/SupportDeleteFormAdmin.su")) {
//			글삭제 폼 작성
			forward = new ActionForward();
			forward.setPath("support/support_delete_form.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/SupportDeleteProAdmin.su")) {
			try {
				action = new SupportDeleteProAdminAction();
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
