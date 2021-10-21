package service.gathering;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dto.GatherDTO;
import service.Action;
import service.ActionForward;

public class GatherAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherAddAction");
		
		request.setCharacterEncoding("utf-8");
		
		GatherDTO gather = new GatherDTO();
		gather.setGathersubject(request.getParameter("gathersubject"));
		gather.setId(request.getParameter("id"));
		gather.setGatherpw(request.getParameter("gatherpw"));
		gather.setLocal(request.getParameter("local"));
		gather.setMembercnt(request.getParameter("membercnt"));		
//		gather.setMembercnt(Integer.parseInt(request.getParameter("membercnt")));		int to String
		gather.setContent(request.getParameter("content"));
		
		GatherDAO dao = GatherDAO.getGatherInstance();
		int result = dao.insert(gather);
		if(result == 1)System.out.println("글작성 성공");
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/GatherListAction.do");
		return forward;
	}

}
