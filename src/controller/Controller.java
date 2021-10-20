package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Action;
import service.ActionForward;
import service.cos.GetCosList;
import service.member.MemberChangePW;
import service.member.MemberChangePWAction;
import service.member.MemberDelete;
import service.member.MemberDetail;
import service.member.MemberFindID;
import service.member.MemberFindPW;
import service.member.MemberIdCheck;
import service.member.MemberInsert;
import service.member.MemberLogin;
import service.member.MemberUpdate;
import service.member.MemberUpdateAction;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		System.out.println("command: " + command);

		Action action = null;
		ActionForward forward = null;

		// 회원 가입
		if (command.equals("/MemberInsert.do")) {
			try {
				action = new MemberInsert();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// ID 중복 검사(ajax)
		} else if (command.equals("/MemberIdCheck.do")) {
			try {
				action = new MemberIdCheck();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 회원 가입 폼
		} else if (command.equals("/MemberForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_insert.jsp");

			// 로그인(회원 인증)
		} else if (command.equals("/MemberLogin.do")) {
			try {
				action = new MemberLogin();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 로그인 폼
		} else if (command.equals("/LoginForm.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/member_login.jsp");

			// 로그아웃
		} else if (command.equals("/Logout.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/member_logout.jsp");

			// 아이디 찾기 폼
		} else if (command.equals("/MemberFindIDAction.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/member_findid.jsp");

			// 아이디 찾기
		} else if (command.equals("/MemberFindID.do")) {
			try {
				action = new MemberFindID();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 아이디 찾기 결과
		} else if (command.equals("/MemberFindIDResult.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/findidsuccess.jsp");

			// 비밀번호 찾기 폼
		} else if (command.equals("/MemberFindPWActioin.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/member_findpw.jsp");

			// 비밀번호 찾기
		} else if (command.equals("/MemberFindPW.do")) {
			try {
				action = new MemberFindPW();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 비밀번호 찾기 결과
		} else if (command.equals("/MemberFindPWResult.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/member/findpwsuccess.jsp");

			// 마이 페이지(상세 페이지)
		} else if (command.equals("/MemberDetail.do")) {
			try {
				action = new MemberDetail();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 회원 정보 수정 폼
		} else if (command.equals("/MemberUpdateAction.do")) {
			try {
				action = new MemberUpdateAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 회원 정보 수정(Update)
		} else if (command.equals("/MemberUpdate.do")) {
			try {
				action = new MemberUpdate();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 비밀번호 변경 폼
		} else if (command.equals("/MemberChangePWAction.do")) {
			try {
				action = new MemberChangePWAction();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 비밀번호 변경
		} else if (command.equals("/MemberChangePW.do")) {
			try {
				action = new MemberChangePW();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 회원 탈퇴 폼
		} else if (command.equals("/MemberDeleteAction.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/member_delete.jsp");

			// 회원 탈퇴(Delete)
		} else if (command.equals("/MemberDelete.do")) {
			try {
				action = new MemberDelete();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// 메인으로 이동
		} else if (command.equals("/Main.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./member/main.jsp");
		} else if (command.equals("/GetCosList.do")) {
			try {
				action = new GetCosList();
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// if(command.equals("/MemberInsert.do")) end

		// 포워딩 처리
		if (forward != null) {
			if (forward.isRedirect()) { // redirect 방식으로 포워딩
				response.sendRedirect(forward.getPath());
			} else { // dispatcher 방식으로 포워딩
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("get");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post");
		process(request, response);

	}

}
