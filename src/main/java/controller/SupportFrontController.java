package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.*;
import action.support.*;
import vo.*;


@WebServlet("*.su")
public class SupportFrontController extends HttpServlet {
	
	
	// --------------------------------------------------------------------------------------

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("==============================");
		System.out.println("1. SupportFrontController 컨트롤러");
	
		
		// --------------------------------------------------------------------------------------

		
				// 한글 인코딩
				request.setCharacterEncoding("UTF-8");
				
				// 서블릿 주소 추출
				String command = request.getServletPath();
				System.out.println("2. 입력 주소 = "+ command);

				
				Action action = null;
				ActionForward forward = null;

				
			// --------------------------------------------------------------------------------------
			
				
				// 후원 리스트로 이동
				if (command.equals("/SupportList.su")) {
					try {
						action = new SupportList();
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}


				// 후원 상세 보기 주소 요청 시 수행
				} else if (command.equals("/SupportDetail.su")) {
					try {
						action = new SupportDetailAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
				//글쓰기 폼 작성	
				} else if (command.equals("/SupportWriteFormAdmin.su")) {
					forward = new ActionForward();
					forward.setPath("support/support_write_admin.jsp");
					forward.setRedirect(false);
					
					
				//글쓰기 실제 수행
				}else if(command.equals("/SupportWriteProAdmin.su")) {
					try {
						action = new SupportWriteProAdminAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						System.out.println("writepro 오류 챱");
						e.printStackTrace();
					}
					
					
				// 후원 수정 요청 시 수행	
				} else if (command.equals("/SupportModifyAdmin.su")) {
					try {
						action = new SuppotModifyFormAdminAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						System.out.println("modifyform 오류 챱");
						e.printStackTrace();
					}
					
					
				//후원 수정 실제 액션
				} else if (command.equals("/SupportModifyProAdmin.su")) {
					try {
						action = new SupportModifyProAdminAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						System.out.println("modifypro 오류 챱 " + e.getMessage());
						e.printStackTrace();
					}

					
				//글삭제 폼 작성
				} else if (command.equals("/SupportDeleteFormAdmin.su")) {
					forward = new ActionForward();
					forward.setPath("support/support_delete_form.jsp");
					forward.setRedirect(false);
					
					
				//글 삭제 프로	
				} else if (command.equals("/SupportDeleteProAdmin.su")) {
					try {
						action = new SupportDeleteProAdminAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						System.out.println("deletepro 오류 챱");
						e.printStackTrace();
					}
				
					
			// --------------------------------------------------------------------------------------
				
					
				//후원금 확인창 이동 
				} else if (command.equals("/GiveMoneyForm.su")) {
					forward = new ActionForward();
					forward.setPath("support/support_give_money.jsp");
					forward.setRedirect(false);
					
					
				} else if (command.equals("/GiveMoneyPro.su")) {
					try {
						action = new MoneyCheckProAction();
						forward = action.execute(request, response);
					} catch (Exception e) {
						System.out.println("moneycheck 오류 챱");
						e.printStackTrace();
					}
					// --------------------------------------------------------------------------------------
				
//					만료된 후원 목록
				} else if (command.equals("/SupportListExpired.su")) {
					try {
						action = new SupportListActionExpired();
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
//					만료된 후원 상세
				}else if(command.equals("/SupportDetailExpired.su")) {
					try {
						action = new SupportDetailActionExpired();
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}


		
		
	// --------------------------------------------------------------------------------------

		
		// 포워딩 처리
		if (forward != null) {
			
			System.out.println("8. 포워딩");
			System.out.println("==============================");
			
			if (forward.isRedirect()) { 
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}

		} 

	}

	
	// --------------------------------------------------------------------------------------

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
