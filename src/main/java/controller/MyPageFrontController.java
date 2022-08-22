package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.mypage.CampaignReviewBlockDetailAction;
import action.mypage.CampaignReviewBlockListAction;
import action.mypage.CartListAction;
import action.mypage.CheckPassAction;
import action.mypage.DeleteCartAction;
import action.mypage.DeleteWishlistAction;
import action.mypage.InsertCartAction;
import action.mypage.InsertWishlistAction;
import action.mypage.OrderListAction;
import action.mypage.UpdateMemberInfoAction;
import action.mypage.WishlistAction;
import vo.ActionForward;

// 마이페이지 컨트롤러
@WebServlet("*.my")
public class MyPageFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MyInfoFrontController");
		request.setCharacterEncoding("UTF-8");
		
		String command = request.getServletPath();
		System.out.println("서블릿 주소 : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/Wishlist.my")) {
			// 위시리스트 조회 서블릿 주소 요청 시 수행
			action = new WishlistAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/InsertWishlist.my")) {
			// 위시리스트 추가 서블릿 주소 요청 시 수행
			action = new InsertWishlistAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("DeleteWishlist.my")) {
			// 위시리스트 삭제 서블릿 주소 요청 시 수행
			action = new DeleteWishlistAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Cart.my")) {
			// 장바구니 서블릿 주소 요청 시 수행
			action = new CartListAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if(command.equals("/InsertCart.my")) {
			// 장바구니 담기 서블릿 주소
			action = new InsertCartAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/DeleteCart.my")) {
			// 장바구니 삭제 서블릿 주소
			action = new DeleteCartAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/OrderList.my")) {
			// 주문 내역 조회 서블릿 주소
			action = new OrderListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Admin.my")) {
			// 관리자 페이지 서블릿 주소
			forward = new ActionForward();
			forward.setPath("mypage/admin.jsp");
		} else if(command.equals("/UpdateMemberInfoForm.my")) {
			// 회원 정보 수정 폼 서블릿 주소
			forward = new ActionForward();
			forward.setPath("mypage/update_info.jsp");
		} else if(command.equals("/CheckPass.my")) {
			// 회원 정보 수정 시 비밀번호 체크
			action = new CheckPassAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/UpdateMemberInfo.my")) {
			// 회원 정보 수정 작업 서블릿 주소
			action = new UpdateMemberInfoAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewBlockList.my")) { 
			//신고글 목록 조회
			action = new CampaignReviewBlockListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewBlockDetail.my")) { 
			//신고글 목록 상세조회
			action = new CampaignReviewBlockDetailAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/CampaignReviewBlockDelete.my")) { 
			//신고글 삭제
			action = new CampaignReviewBlockDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
//		========================================================================================================================
	
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
