package action.community;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.community.FreeBoardDetailService;
import vo.ActionForward;
import vo.community.FreeboardDTO;

public class FreeBoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("FreeBoardDetailAction");
			
			ActionForward forward = null;
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));

			FreeBoardDetailService service = new FreeBoardDetailService();
			service.increaseReadcount(board_num);
			
			FreeboardDTO board = service.getBoard(board_num);
			
			request.setAttribute("board", board);
			
			forward = new ActionForward();
			forward.setPath("community/freeboard_view.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
	
	}