package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.community.*;
import action.store.StoreItemDetailAction;
import action.store.StoreItemListAction;
import action.store.StoreWriteProAction;
import vo.*;

//커뮤니티(캠페인 후기, 반려나무 성장일기, 큐앤에이, 공지사항, 자유게시판) 컨트롤러
@WebServlet("*.cm")
public class CommunityFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CommunityFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		
		Action action = null; // Action 클래스 인스턴스를 관리하는 변수
		ActionForward forward = null; // 포워딩 정보를 관리하는 변수

//		=================================================================================================================================
		
		if(command.equals("/FreeBoardWriteForm.cm")) { //자유게시판 작성 폼
			forward = new ActionForward();
			forward.setPath("community/freeboard_write.jsp");
			forward.setRedirect(false);
		} else if (command.equals("/FreeBoardWritePro.cm")) { //자유게시판 작성 동작
			try {
				action = new FreeBoardWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FreeBoardList.cm")) { //자유게시판 목록
			try {
				action = new FreeBoardListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		} else if(command.equals("/FreeBoardDetail.cm")) {	//자유게시판 글 상세조회
			action = new FreeBoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
//		=================================================================================================================================
		
		else if(command.equals("/CampaignReviewWriteForm.cm")) { //캠페인후기 작성 폼
			forward = new ActionForward();
			forward.setPath("community/campaign_review_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/CampaignReviewPro.cm")) { //캠페인후기 작성 동작
			try {
				action = new CampaignReviewWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewModifyForm.cm")) { //캠페인후기 수정 폼
			try {
				action = new CampaignReviewModifyFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewModifyPro.cm")) { //캠페인후기 수정 동작
			try {
				action = new CampaignReviewModifyProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewList.cm")) { //캠페인후기 목록
			try {
				action = new CampaignReviewListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewDetail.cm")) { //캠페인후기 상세조회
			try {
				action = new CampaignReviewDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewDeleteForm.cm")) { //캠페인후기 글 삭제 폼
			forward = new ActionForward();
			forward.setPath("community/campaign_review_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/CampaignReviewDeletePro.cm")) { //캠페인후기 글 삭제 동작
			try {
				action = new CampaignReviewDeleteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewBlockForm.cm")) { //캠페인후기 글 신고 폼
			try {
				action = new CampaignReviewBlockFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewBlockPro.cm")) { //캠페인후기 글 신고 동작
			try {
				action = new CampaignReviewBlockProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		=================================================================================================================================
		
		//포워딩처리
		if(forward != null) { 
			if(forward.isRedirect()) { //redirect 방식
				response.sendRedirect(forward.getPath());
			} else { //dispatcher 방식
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
