package service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MemberDAO;
import dto.MemberDTO;
import service.Action;
import service.ActionForward;

public class MemberUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MemberUpdate");
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		// 업로드할 디렉토리 위치 구하기
		String path = request.getRealPath("upload");
		System.out.println("path:" + path);
		
		int size = 1024 * 1024; // 첨부파일의 크기(단위:Byte) : 1MB
		
		MultipartRequest multi = new MultipartRequest(
							request, 
							path, 							// 업로드할 디렉토리 위치
							size, 							// 첨부파일의 크기 : 1MB
							"UTF-8", 						// 인코딩 타입 설정
							new DefaultFileRenamePolicy()); // 중복 문제 해결
				
		
		MemberDTO member = new MemberDTO();
		member.setId(multi.getParameter("id"));
		member.setPasswd(multi.getParameter("passwd"));
		member.setName(multi.getParameter("name"));
		member.setYear(Integer.parseInt(multi.getParameter("year")));
		member.setMonth(Integer.parseInt(multi.getParameter("month")));
		member.setDay(Integer.parseInt(multi.getParameter("day")));
		member.setGender(multi.getParameter("gender"));
		member.setMailid(multi.getParameter("mailid"));
		member.setDomain(multi.getParameter("domain"));
		member.setPhone1(multi.getParameter("phone1"));
		member.setPhone2(multi.getParameter("phone2"));
		member.setPhone3(multi.getParameter("phone3"));
		member.setLocal(multi.getParameter("local"));
		member.setImage(multi.getFilesystemName("image"));
				
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO old = dao.getMember(member.getId());
		
		// 비밀번호 비교
		if(old.getPasswd().equals(member.getPasswd())) {	// 비밀번호 일치시
			int result = dao.update(member);				// 회원 정보 수정
			if(result == 1) System.out.println("회원 수정 성공");
			out.println("<script>");
			out.println("location.href='./member/updatesuccess.jsp'");
			out.println("</script>");
			out.close();
			
			return null;
					
		}else {												// 비밀번호 불일치시
			out.println("<script>");
			out.println("alert('비밀번호 정보가 올바르지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
					
			return null;
		}
				
//			ActionForward forward = new ActionForward();
//			forward.setRedirect(false);
//			forward.setPath("/MemberDetail.do");
//				
//			return forward;
		}

	}
