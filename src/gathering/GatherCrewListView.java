package service.gathering;

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

public class GatherCrewListView implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("GatherCrewListView");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String page = request.getParameter("page");
		
//		HttpSession session = request.getSession();
//		String id = (String) session.getAttribute("id");
		
//		MemberDAO mdao = MemberDAO.getInstance();
//		MemberDTO member = mdao.getMember(id);
		
		GatherDAO gdao = GatherDAO.getGatherInstance();
		GatherDTO gather = gdao.getDetail(no);
		
		
		PeopleDAO pdao = PeopleDAO.getPeopleInstance();		
		List<PeopleDTO> plist = pdao.getplist(no);
		System.out.println("모임원 리스트 출력:"+plist);
		
		request.setAttribute("plist", plist);
		request.setAttribute("gather_name", gather.getGathersubject());
		request.setAttribute("no", no);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./gathering/gathering_crewlist.jsp");
		
		return forward;
	}

}
