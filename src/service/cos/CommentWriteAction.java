package service.cos;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CommentDAO;
import dto.CommentBean;
import service.Action;
import service.ActionForward;

public class CommentWriteAction implements Action
{
	@Override
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		
		CommentDAO dao = CommentDAO.getInstance();
		CommentBean comment = new CommentBean();
		
		// �ĸ����� ���� �����´�.
		String comment_board = request.getParameter("comment_board");
		String comment_id = request.getParameter("comment_id");
		String comment_content = request.getParameter("comment_content");
		
		comment.setComment_num(dao.getSeq());	// ��� ��ȣ�� ������������
		comment.setComment_board(comment_board);
		comment.setComment_id(comment_id);
		comment.setComment_content(comment_content);
		
		boolean result = dao.insertComment(comment);

		if(result){
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("1");
			out.close();
		}
			
		return null;
	}
}
