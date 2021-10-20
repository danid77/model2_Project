package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberChangePW implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberChangePW");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
//		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String passwd_old = request.getParameter("passwd_old");
		String passwd_new = request.getParameter("passwd_new");

		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPasswd(passwd_new);
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(id);
		
		// 비밀번호 비교
		if(old.getPasswd().equals(passwd_old)) {	// 비밀번호 일치 시
			int result = dao.changePW(member);
			System.out.println("result는 "+result);
			if(result == 1)System.out.println("비밀번호 변경 성공");
			
			out.println("<script>");
			out.println("location.href='./member/changesuccess.jsp'");
			out.println("</script>");
			out.close();
			
			return null;
			
		}else {										// 비밀번호 불일치 시
			out.println("<script>");
			out.println("alert('비밀번호 정보가 올바르지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			
			return null;
		}
				
//		ActionForward forward = new ActionForward();
//		forward.setRedirect(false);
//		forward.setPath("/MemberDetail.do");
		
//		return forward;
	}

}
