package service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberUpdateAction");
		
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = dao.getMember(id);		
		System.out.println("상세 정보:"+member);
		
		// 공유 설정
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);			// dispatcher 방식으로 포워딩
		forward.setPath("./member/member_update.jsp");
		
		return forward;
	}

}
