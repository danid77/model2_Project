package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import service.Action;
import service.ActionForward;

public class MemberLogin implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("MemberLogin");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();	
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println("id는"+id);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberAuth(id, passwd);
		if(result == 1) {
			System.out.println("로그인 성공");
			session.setAttribute("id", id);
			
			out.println("<script>");
			out.println("location.href='./member/loginsuccess.jsp'");
			out.println("</script>");
			out.close();
			
			return null;
			
		}else {
			System.out.println("로그인 실패");
			out.println("<script>");
			out.println("alert('회원 정보가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
			
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("./member/main.jsp");	
				
	}

	
}
