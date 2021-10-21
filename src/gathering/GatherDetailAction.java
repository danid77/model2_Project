package service.gathering;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dto.GatherDTO;
import service.Action;
import service.ActionForward;

public class GatherDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherDetailAction");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");
		System.out.println("page값:"+page);
		GatherDAO dao = GatherDAO.getGatherInstance();
		GatherDTO gather = dao.getDetail(no);
		
		// 글내용 줄바꿈
		String content = gather.getContent().replace("\n", "<br>");
		
		// 공유 설정
		request.setAttribute("content", content);
		request.setAttribute("gather", gather);
		request.setAttribute("page", page);
		
		ActionForward forword = new ActionForward();
		forword.setRedirect(false);
		forword.setPath("./gathering/gathering_detail.jsp");
		return forword;
	}

	// cf)  / ./BoardDetailAction.do 이런 오류가 발생하면. 
			// 1. response.setContentType("text/html; charset=UTF-8"); 확인
			// 2. dispatcher(false)방식일때 ./BoardDetailAction.do에서 점 뺴고 실행하기
			// 3. 포워딩 방식(forward.setRedirect)을 dispatcher(false)방식에서 redirect(true)로 바꿔보기(단 setPath에서 앞에 점 붙이기  )
}
