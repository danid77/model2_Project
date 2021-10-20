package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberFindPW implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberFindPW");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String mailid = request.getParameter("mailid");
		String domain = request.getParameter("domain");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = dao.getMember(id);
		System.out.println("상세 정보:"+member);
		System.out.println("비밀번호 찾기:"+member.getPasswd());
		
		HttpSession session = request.getSession();
		session.setAttribute("userid", id);
		session.setAttribute("userpasswd", member.getPasswd());
		
		if(member != null) {
		if(member.getMailid().equals(mailid) && member.getDomain().equals(domain)) {
			System.out.println("비밀번호 찾기 성공");	
			
			out.println("<script>");
			out.println("location.href='./MemberFindPWResult.do'");
			out.println("</script>");
			out.close();
			
			
		}else {
			out.println("<script>");
			out.println("alert('입력하신 정보와 일치하는 회원이 존재하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
		}
//		ActionForward forward = new ActionForward();
//		
		return null;
	}

}
