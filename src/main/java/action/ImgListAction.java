package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ImgListService;
import vo.ActionForward;
import vo.ImgDTO;

public class ImgListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3 - 액션");
		ActionForward forward = null;
		
		
		// -------------------------------------------------------------------------------------
		
		
		ImgListService service = new ImgListService();
		ArrayList<ImgDTO> boardList = ImgListService.getBoardList();
		
		
		request.setAttribute("boardList", boardList);
		// -------------------------------------------------------------------------------------

		
		forward = new ActionForward();
		System.out.println("7 - 액션");
		forward.setPath("img/imgList.jsp");
		forward.setRedirect(false);;
		
		return forward;
	}

}
