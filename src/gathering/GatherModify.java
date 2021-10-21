package service.gathering;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dto.GatherDTO;
import service.Action;
import service.ActionForward;

public class GatherModify implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherModify");
		
		response.setContentType("text/html; charset=UTF-8");			// 알림창 인코딩
		request.setCharacterEncoding("utf-8");	// 넘어오는 값 인코딩
		
		// out 객체
		PrintWriter out = response.getWriter();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");
		String gatherpw = request.getParameter("gatherpw");
		
		GatherDTO gather = new GatherDTO();
		gather.setNo(no);
		
		gather.setGathersubject(request.getParameter("gathersubject"));
		gather.setId(request.getParameter("id"));
		gather.setLocal(request.getParameter("local"));
		gather.setMembercnt(request.getParameter("membercnt"));
		gather.setContent(request.getParameter("content"));
		
		//  dao객체를 생성해서 비번 끄집어 내기
		GatherDAO dao = GatherDAO.getGatherInstance();
		GatherDTO old = dao.getDetail(no);		// 상세정보를 구해오는 메소드 : 구해온 값을 old에 저장
		
		// 비번 비교
		if(old.getGatherpw().equals(gatherpw)) {		// 비번비교
			int result = dao.update(gather);						// 글 수정
			if(result == 1) System.out.println("글수정 성공");
			
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
		forword.setPath("/GatherDetailAction.do?no="+no+"&page="+page);
		return forword;
	}

}
