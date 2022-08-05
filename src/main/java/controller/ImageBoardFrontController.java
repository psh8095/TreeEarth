package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ImgListAction;
import action.imgProAction;
import vo.ActionForward;

@WebServlet("*.im")
public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1 - BoardFrontController");
		
		// POST 방식 요청에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("command : " + command);
		Action action = null;
		ActionForward forward = null;	
		
		
		
		// ----------------------------------------------------------------------------------------

		
		
		//이미지 폼
		if(command.equals("/imgForm.im")) {
			forward = new ActionForward();
			forward.setPath("img/imgForm.jsp");
			forward.setRedirect(false); 
			
			
		//이미지 폼 프로	
		} else if(command.equals("/imgProAction.im")){
			
			try {
				action = new imgProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		//리스트 액션으로 갑니다잉	
		} else if(command.equals("/imgList.im")) {
			try {
				action = new ImgListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		
		// ----------------------------------------------------------------------------------------
				
		
				
		if(forward != null) { 
			
			System.out.println("0 - 이동합니다.");
			
			if(forward.isRedirect()) { 
				response.sendRedirect(forward.getPath());
			} else { 
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	
		// ----------------------------------------------------------------------------------------

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}







