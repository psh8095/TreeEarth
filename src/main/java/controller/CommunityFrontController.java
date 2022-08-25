package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import action.*;
import action.community.*;
import vo.*;

//커뮤니티(캠페인 후기, 반려나무 성장일기, 큐앤에이, 공지사항, 자유게시판) 컨트롤러
@WebServlet("*.cm")
public class CommunityFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("1.CommunityFrontController");
		
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("2.command : " + command);
		
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
		} 
//			else if(command.equals("/FreeBoardDetail.cm")) {
//			try {
//				action = new FreeBoardDetailAction();
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/FreeBoardDeleteForm.cm")) {
//			forward = new ActionForward();
//			forward.setPath("community/freeboard_delete.jsp");
//			forward.setRedirect(false); // Dispatcher 방식(생략 가능)
//		} else if(command.equals("/FreeBoardDeletePro.cm")) {
//			action = new FreeBoardDeleteProAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/FreeBoardModifyForm.cm")) {
//			// 글 수정에 필요한 게시물 조회 비즈니스 로직 처리를 위해
//			// FreeBoardModifyFormAction 클래스의 execute() 메서드 호출
//			action = new FreeBoardModifyFormAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/FreeBoardModifyPro.cm")) {
//			action = new FreeBoardModifyProAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/FreeBoardReplyForm.cm")) {
//			// FreeBoardReplyFormAction 을 통해 답글 달 원본 게시물 상세 정보 조회 후
//			// freeboard_reply.jsp 페이지에서 표시(제목, 내용만 표시)
//			action = new FreeBoardReplyFormAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else if(command.equals("/FreeBoardReplyPro.cm")) {
//			action = new FreeBoardReplyProAction();
//			
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
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
		
		else if(command.equals("/DiaryList.cm")) { //반려나무 성장일지 목록
			try {
				action = new DiaryListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/DiaryBoardDetail.cm")) { //성장일지 상세 조회
			try {
				action = new DiaryBoardDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DiaryWriteForm.cm")) { //성장일지 작성 폼
			forward = new ActionForward();
			forward.setPath("community/diary_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/DiaryWritePro.cm")) { //성장일지 작성 동작
			try {
				action = new DiaryWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DiaryModifyForm.cm")) { //성장일지 수정 폼
			try {
				action = new DiaryModifyFormAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/DiaryModifyPro.cm")) { //성장일지 수정 동작
			try {
				action = new DiaryModifyProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DiaryDeleteForm.cm")) { //성장일지 삭제 폼
			forward = new ActionForward();
			forward.setPath("community/diary_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/DiaryDeletePro.cm")) { //성장일지 삭제 동작
			try {
				action = new DiaryDeleteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		=================================================================================================================================
		
		else if(command.equals("/QnaWriteForm.cm")) { //qna 작성 폼
			forward = new ActionForward();
			forward.setPath("community/qna_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/QnaWritePro.cm")) { //qna 작성 동작
			try {
				action = new QnaWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaList.cm")) { //qna 목록
			try {
				action = new QnaListAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/QnaDeleteForm.cm")) { //qna 삭제 폼
			forward = new ActionForward();
			forward.setPath("community/qna_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/QnaDeletePro.cm")) { //qna 삭제 동작
			try {
				action = new QnaDeleteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		=================================================================================================================================
		
		//포워딩처리
		System.out.println("8. 포워딩");
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
