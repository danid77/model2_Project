package service.gathering;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GatherDAO;
import dto.GatherDTO;
import service.Action;
import service.ActionForward;

public class GatherListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("GatherListAction");
		
		int page = 1;			// 첫번째 기본변수 : 현재 페이지 번호
		int limit = 10;			// 두번째 기본변수 : 한 화면에 출력할 데이터 갯수
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));		// 정수형으로 변환	
		}
		
		// page = 1 : startRow=1, endRow=10
		// page = 2 : startRow=11, endRow=20
		int startRow = (page - 1) * limit + 1;
		int endRow = page * limit;
		
		GatherDAO dao = GatherDAO.getGatherInstance();
		int listcount = dao.getCount();
		System.out.println("listcount : " + listcount );
		
		List<GatherDTO> gatherlist = dao.getlist(startRow, endRow);
		System.out.println("gatherlist : " + gatherlist);
		
		// 총페이지
		int pageCount = listcount/limit + ((listcount%limit == 0)? 0 : 1);	//파생변수 
		
		int startPage = ((page - 1)/10) * limit + 1;
		int endPage = startPage + 10 - 1;
		
		if(endPage > pageCount) endPage = pageCount;	// 실제 존재하는 페이지수만 구해올 수 있게해줌
		
//		request.setParameter() 와 request.getParameter()를 이용하면 String의 값 밖에는 주고 받을 수 없다.
// 	Action으로 넘어온 값을 변경시킨후 JSP 페이지로 넘겨주기 위해서는 request.setAttribute() 
//		를 써서 넘겨주고 JSP 페이지에서는 request.getAttribute()를 써서 받아야한다.
//		jsp파일에서 el을 통해서 공유되는 값으로 바로 출력됨 
		request.setAttribute("page", page);								//int
		request.setAttribute("listcount", listcount);					//int
		request.setAttribute("gatherlist", gatherlist);				//int
		request.setAttribute("pageCount", pageCount);			//int
		request.setAttribute("startPage", startPage);				//int
		request.setAttribute("endPage", endPage);					//int
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./gathering/gathering_list.jsp");
		
		return forward;
	}

}
