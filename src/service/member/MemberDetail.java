package service.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.PeopleDAO;
import dto.MemberDTO;
import dto.PeopleDTO;
import service.Action;
import service.ActionForward;

public class MemberDetail implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberDetail");

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		// 회원 정보 조회
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO member = dao.getMember(id);
		System.out.println("상세 정보:" + member);

		// 공유 설정
		request.setAttribute("member", member);

		// 내 모임 조회
		PeopleDAO pdao = PeopleDAO.getPeopleInstance();
		List<PeopleDTO> list = pdao.mygatherings(id);

		System.out.println("내 모임 리스트 출력:" + list);

		// 공유 설정
		request.setAttribute("list", list);

		ActionForward forward = new ActionForward();

		forward.setRedirect(false); // dispatcher 방식으로 포워딩
		forward.setPath("/member/member_detail.jsp");

		return forward;
	}

}
