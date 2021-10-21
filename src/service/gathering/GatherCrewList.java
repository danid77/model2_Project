package service.gathering;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GatherDAO;
import dao.MemberDAO;
import dao.PeopleDAO;
import dto.GatherDTO;
import dto.MemberDTO;
import dto.PeopleDTO;
import service.Action;
import service.ActionForward;

public class GatherCrewList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherCrewList");

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberDTO member = mdao.getMember(id);

		GatherDAO gdao = GatherDAO.getGatherInstance();
		GatherDTO gather = gdao.getDetail(no);

		PeopleDTO people = new PeopleDTO();
		people.setNo(no);
		people.setGather_name(gather.getGathersubject());
		people.setId(id);
		people.setLocal(member.getLocal());
		people.setGender(member.getGender());

		PeopleDAO pdao = PeopleDAO.getPeopleInstance();

		// 모임의 정원과 현재 인원
		int mc = Integer.parseInt(gather.getMembercnt()); // 모임의 정원
		int peoplecnt = pdao.peoplecnt(no); // 모임의 현재 참여 인원

		System.out.println("모임 정원: " + mc);
		System.out.println("현재 모임 참여 인원: " + peoplecnt);

		// 개별 모임에 회원이 가입되어 있는지 확인
		int selectresult = pdao.selectmember(no, id);

		if (selectresult == 1) { // 모임에 가입되어 있지 않은 회원이면
			if (mc > peoplecnt) {
				// 모임원 테이블에 회원 추가
				pdao.insertmember(people);

				System.out.println("모임 가입 성공");

				List<PeopleDTO> plist = pdao.getplist(no);
				System.out.println("모임원 리스트 출력:" + plist);

				request.setAttribute("plist", plist);
				request.setAttribute("gather_name", gather.getGathersubject());
				request.setAttribute("no", no);
				request.setAttribute("page", page);

			} else {
				out.println("<script>");
				out.println("alert('정원이 초과되었습니다.')");
				out.println("history.go(-1)");
				out.println("</script>");
				out.close();

				return null;
			}

		} else if (selectresult == -1) {
			out.println("<script>");
			out.println("alert('이미 가입한 모임입니다.')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();

			return null;
		}

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./gathering/gathering_crewlist.jsp");

		return forward;
	}

}