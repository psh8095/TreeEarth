package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.store.InsertOrderAction;
import action.store.OrderAction;
import action.store.StoreDeleteProAction;
import action.store.StoreDetailAction;
import action.store.StoreItemDetailAction;
import action.store.StoreItemListAction;
import action.store.StoreListAction;
import action.store.StoreModifyFormAction;
import action.store.StoreModifyProAction;
import action.store.StoreOrderDetailAction;
import action.store.StoreOrderListAction;
import action.store.StoreQnaDeleteProAction;
import action.store.StoreQnaDetailAction;
import action.store.StoreQnaListAction;
import action.store.StoreQnaModifyFormAction;
import action.store.StoreQnaModifyProAction;
import action.store.StoreQnaReplyFormAction;
import action.store.StoreQnaReplyProAction;
import action.store.StoreQnaWriteProAction;
import action.store.StoreReviewDeleteProAction;
import action.store.StoreReviewDetailAction;
import action.store.StoreReviewListAction;
import action.store.StoreReviewModifyFormAction;
import action.store.StoreReviewModifyProAction;
import action.store.StoreReviewWriteFormAction;
import action.store.StoreReviewWriteProAction;
import action.store.StoreWriteProAction;
import vo.ActionForward;

// 스토어 컨트롤러
@WebServlet("*.st")
public class StoreFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StoreFrontController");
		
		// POST 방식 요청에 대한 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("서블릿 주소 : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/StoreItemList.st")) {
			// 스토어 메인페이지 상품 목록 주소
			action = new StoreItemListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} 
		else if(command.equals("/StoreItemDetail.st")) {
			// 상품 상세 조회 주소
			action = new StoreItemDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		//-------------------관리자 영역----------------------------------
		else if (command.equals("/StoreWriteForm.st")) {
			// 상품글 등록 페이지로 이동
			forward = new ActionForward();
			forward.setPath("store/store_write.jsp"); 
			forward.setRedirect(false);
		} else if (command.equals("/StoreWritePro.st")) {
			try {
				action = new StoreWriteProAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else if(command.equals("/StoreDeleteForm.st")) {
			// 등록한 상품글 삭제
			forward = new ActionForward();
			forward.setPath("store/store_deleteAction.jsp");
			forward.setRedirect(false); // Dispatcher 방식(생략 가능)
		} else if(command.equals("/StoreDeletePro.st")) {
			action = new StoreDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreModifyForm.st")) {
			// 등록한 상품글 수정
			action = new StoreModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreModifyPro.st")) {
			action = new StoreModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreList.st")) {
			// 등록한 상품 목록 확인
			action = new StoreListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreDetail.st")) {
			// 상세 조회
			try {
				action = new StoreDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreOrderList.st")) {
			// 주문 목록 확인
			action = new StoreOrderListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreOrderDetail.st")) {
			// 상세 조회
			try {
				action = new StoreOrderDetailAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaReplyForm.bo")) {
			// Qna 관리자 답변 페이지
			action = new StoreQnaReplyFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaReplyPro.bo")) {
			// Qna 관리자 답변 동작 기능
			action = new StoreQnaReplyProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//----------------사용자 영역------------------------------------
		else if(command.equals("/StoreReviewWriteForm.st")) {
			// 회원 상품 구매후기 폼 주소
			action = new StoreReviewWriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreReviewWritePro.st")) {
			// 회원 상품 구매후기 등록 기능
			action = new StoreReviewWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreReviewList.st")) {
			// 상품 구매후기 목록 조회
			action = new StoreReviewListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreReviewDetail.st")) {
			// 상품 구매후기 상세 조회
			action = new StoreReviewDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreReviewModifyForm.st")) {
			// 상품 구매후기 수정 폼 주소
			action = new StoreReviewModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreReviewModifyPro.st")) {
			// 상품 구매후기 수정 동작 기능
			action = new StoreReviewModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Order.st")) {
			// 주문 페이지 서블릿 주소
			action = new OrderAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if(command.equals("/StoreReviewDeleteForm.st")) {
			// 상품 구매후기 삭제 폼 작성
			forward = new ActionForward();
			forward.setPath("store/store_review_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/StoreReviewDeletePro.st")) {
			// 상품 구매후기 삭제 동작 기능
			action = new StoreReviewDeleteProAction();

      try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/InsertOrder.st")) {
			// 상품 주문 서블릿 주소
			action = new InsertOrderAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaWriteForm.st")) {
			// 상품 간단 문의 폼 주소
			forward = new ActionForward();
			forward.setPath("store/store_qna_write.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/StoreQnaWritePro.st")) {
			// 상품 간단 문의 등록 기능 주소
			action = new StoreQnaWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaList.st")) {
			// 상품 문의 목록 조회 주소
			action = new StoreQnaListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaDetail.st")) {
			// 상품 문의글 상세 조회 주소
			action = new StoreQnaDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaModifyForm.st")) {
			// 상품 문의글 수정 폼 주소
			action = new StoreQnaModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaModifyPro.st")) {
			// 상품 문의글 수정 동작 기능
			action = new StoreQnaModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/StoreQnaDeleteForm.st")) {
			// 상품 문의글 삭제 폼 작성
			forward = new ActionForward();
			forward.setPath("store/store_qna_delete.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/StoreQnaDeletePro.st")) {
			// 상품 문의글 삭제 동작 기능
			action = new StoreQnaDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		
		
		// ActionForward 객체에 저장된 포워딩 정보에 따른 포워딩 작업 수행하기 위한 공통코드 작성
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
