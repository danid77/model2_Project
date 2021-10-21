package service.cos;

import dao.CommentDAO;
import dto.CommentBean;
import service.Action;
import service.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentReplyFormAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("CommentReplyFormAction.java");
        ActionForward forward = new ActionForward();

        int comment_num = Integer.parseInt(request.getParameter("num"));

        CommentDAO dao = CommentDAO.getInstance();
        CommentBean comment = dao.getComment(comment_num);

        request.setAttribute("comment", comment);

        forward.setRedirect(false);
        forward.setPath("/cos/commentReplyForm.jsp");

        return forward;
    }
}
