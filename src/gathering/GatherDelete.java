package service.gathering;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dao.PeopleDAO;
import dto.GatherDTO;
import dto.PeopleDTO;
import service.Action;
import service.ActionForward;

public class GatherDelete implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherDelete");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : "+no);
		String page = request.getParameter("page");
		String gatherpw = request.getParameter("gatherpw");
		
	//  dao객체를 생성해서 비번 끄집어 내기
			GatherDAO gadao = GatherDAO.getGatherInstance();
			GatherDTO gaold = gadao.getDetail(no);		// 상세정보를 구해오는 메소드 : 구해온 값을 old에 저장
			System.out.println("상세정보 구하기 성공");
			
			PeopleDAO pedao = PeopleDAO.getPeopleInstance();
			
			
			// 비번 비교
			if(gaold.getGatherpw().equals(gatherpw)) {		// 비번비교
				int peresult = pedao.delete(no);
				int garesult = gadao.delete(no);						// 글 삭제
				if(peresult == 1) System.out.println("모임원 정보 삭제");
				if(garesult == 1) System.out.println("글삭제 성공");
				
				
				
			}else {																		// 비번 불일치
				out.println("<script>");
				out.println("alert('비번이 일치하지 않습니다.');");
				out.println("history.go(-1);");
				out.println("</script>");
				out.close();
				
				return null;	
			}
		
		
		ActionForward forword = new ActionForward();
		forword.setRedirect(false);				
		forword.setPath("/GatherListAction.do?page="+page);
		return forword;
	}

}
