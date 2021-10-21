package service.cos;

import dao.CommentDAO;
import dto.CommentBean;
import service.Action;
import service.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CommentReplyAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int comment_num = Integer.parseInt(request.getParameter("comment_num"));
        String comment_board = request.getParameter("comment_board");
        String comment_id = request.getParameter("comment_id");
        String comment_content = request.getParameter("comment_content");

        CommentDAO dao = CommentDAO.getInstance();

        CommentBean comment = new CommentBean();
        comment.setComment_num(dao.getSeq());
        comment.setComment_board(comment_board);
        comment.setComment_id(comment_id);
        comment.setComment_content(comment_content);
        comment.setComment_parent(comment_num);

        boolean result = dao.insertComment(comment);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(result) out.println("1");
        else out.println("0");

        out.close();

        return null;
    }
}
