package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import service.Action;
import service.ActionForward;

public class MemberIdCheck implements Action {
	// 메소드 오버라이딩
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberIdCheck");
		
		PrintWriter out = response.getWriter();		// out 객체 생성
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		System.out.println("id:"+id);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.idcheck(id);				// ID 중복 검사
		System.out.println("result:"+result);		// 1  : 중복 ID
													// -1 : 사용 가능한 ID
		
		// 브라우저에 출력되는 값이 callback 함수로 리턴된다.
		out.println(result);
		
		return null;
	}

}
