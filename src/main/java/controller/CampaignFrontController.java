package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.campaign.*;
import vo.ActionForward;

//캠페인 컨트롤러(모집중인 캠페인 목록 조회, 종료된 캠페인 목록 조회, 캠페인 참가 신청서 작성, 캠페인 아이디어 공모글 작성, 캠페인 공고 작성/수정/삭제)
@WebServlet("*.cp")
public class CampaignFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, 
	IOException {
			System.out.println("CampaignFrontController");
			request.setCharacterEncoding("UTF-8");
			String command = request.getServletPath();
			System.out.println("서블릿 주소 : " + command);
			
			Action action = null; 
			ActionForward forward = new ActionForward();
			
		//-------------------------------------------------------------------------------------
		if(command.equals("/CampaignApplyForm.cp")) {
				// 캠페인 참가 신청서 서블릿 주소
				forward = new ActionForward();
				forward.setPath("campaign/campaign_apply.jsp");
		} else if(command.equals("/CampaignApplyPro.cp")) {
				// 캠페인 참가 신청서 서블릿 주소
				action = new CampaignApplyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignWriteForm.cp")){//캠페인 작성 폼
				forward = new ActionForward();
				forward.setPath("campaign/campaign_write.jsp");
				forward.setRedirect(false);
		} else if(command.equals("/CampaignWritePro.cp")) {//캠페인 작성 동작
				action = new CampaignWriteProAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if(command.equals("/CampaignList.cp")) {//캠페인 목록
				action = new CampaignListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else if(command.equals("/CampaignDetail.cp")) {//캠페인 상세조회
				action = new CampaignDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignDeleteForm.cp")) {//캠페인 삭제 폼
				 forward = new ActionForward();
				 forward.setPath("/campaign/campaign_delete.jsp");
				 forward.setRedirect(false);
		} else if(command.equals("/CampaignDeletePro.cp")) {//캠페인 삭제 동작
				action = new CampaignDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//==============================================================================
		//포워딩 작업 수행하기 위한 공통코드
		if(forward != null) {
			if(forward.isRedirect()) {//redirect 방식
				response.sendRedirect(forward.getPath());
			} else {//dispatcher 방식
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
