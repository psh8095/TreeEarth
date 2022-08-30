package action.support;

import java.io.*;

import javax.servlet.http.*;

import action.*;
import svc.support.*;
import vo.*;
import vo.support.*;

public class MoneyCheckProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. MoneyCheckProAction");
		
		ActionForward forward = null;
		
	// ----------------------------------------------------------------------------------------
		
		int total_money = Integer.parseInt(request.getParameter("total_money"));
		int idx = Integer.parseInt(request.getParameter("idx"));
		String mem_id = request.getParameter("mem_id");
		int sup_idx = Integer.parseInt(request.getParameter("sup_idx"));
		int suphi_money = Integer.parseInt(request.getParameter("suphi_money"));
//		System.out.println("3-1. " + total_money);
//		System.out.println("3-2. " + idx);
//		System.out.println(mem_id + sup_idx + suphi_money);
		
		SupportDTO dto = new SupportDTO();
		dto.setSup_money(total_money);
		dto.setSup_idx(idx);
		
		SupportHistoryDTO supporthistory = new SupportHistoryDTO();
		supporthistory.setMem_id(mem_id);
		supporthistory.setSup_idx(sup_idx);
		supporthistory.setSuphi_money(suphi_money);
		
	// ----------------------------------------------------------------------------------------

		MoneyHistoryService service_hi = new MoneyHistoryService();
		service_hi.regiestSupport(supporthistory);
		
		//머니 저장
		MoneyCheckProService service = new MoneyCheckProService();
		boolean isCorrectMoney = service.checkMoney(dto);
		
		
	// ----------------------------------------------------------------------------------------

		if(isCorrectMoney) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('후원이 완료되었습니다.')");
			out.println("opener.location.href='SupportListAction.su'");
			out.println("window.close();");
			out.println("</script>");
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('후원 실패.')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
