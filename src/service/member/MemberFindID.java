package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberFindID implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberFindID");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String mailid = request.getParameter("mailid");
		String domain = request.getParameter("domain");
		
		MemberDAO dao = MemberDAO.getInstance();
		String id = dao.getID(name, mailid, domain);
		System.out.println("id:"+id);
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", id);		
		
		if(id != null) {
			System.out.println("아이디 찾기 성공");	
			
			out.println("<script>");
			out.println("location.href='./MemberFindIDResult.do'");
			out.println("</script>");
			out.close();
			
			return null;
			
		}else {
			out.println("<script>");
			out.println("alert('입력하신 정보와 일치하는 회원이 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		
//		ActionForward forward = new ActionForward();
//		
//		return null;
	}

}
