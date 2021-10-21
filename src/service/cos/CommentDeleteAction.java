package service.cos;

import dao.CommentDAO;
import service.Action;
import service.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CommentDeleteAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int comment_num = Integer.parseInt(request.getParameter("comment_num"));

        CommentDAO dao = CommentDAO.getInstance();
        boolean result = dao.deleteComment(comment_num);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(result) out.println("1");

        out.close();
        return null;
    }
}
