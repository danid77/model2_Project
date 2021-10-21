package service.gathering;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dto.GatherDTO;
import service.Action;
import service.ActionForward;

public class GatherModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherModifyAction");
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");
		
		GatherDAO dao = GatherDAO.getGatherInstance();
		GatherDTO gather = dao.getDetail(no);			// 상세 정보 구하기
		System.out.println("상세정보 구하기 성공");
		
		// 공유 설정
		request.setAttribute("gather", gather);
		request.setAttribute("page", page);
		
		
		ActionForward forword = new ActionForward();
		forword.setRedirect(false);				// request객체로 공유했기때문에 dispatcher 포워딩 사용
		forword.setPath("./gathering/gathering_update.jsp");
		return forword;
	}

}
