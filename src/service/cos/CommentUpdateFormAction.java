package service.cos;

import dao.CommentDAO;
import dto.CommentBean;
import service.Action;
import service.ActionForward;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommentUpdateFormAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("CommentUpdateFormAction.java");
    	ActionForward forward = new ActionForward();
    	
        int comment_num = Integer.parseInt(request.getParameter("num"));
        System.out.println(comment_num);

        CommentDAO dao = CommentDAO.getInstance();
        CommentBean comment = dao.getComment(comment_num);

        HttpSession session = request.getSession();
        session.setAttribute("comment", comment);
        
        PrintWriter out = response.getWriter();
        
        out.print("<script>");
        out.print("location.href='./cos/commentUpdateForm.jsp'");
        out.print("</script>");
        out.close();
        
        
//        forward.setRedirect(true);
//        forward.setPath("./cos/test.jsp");
//        
//        return forward;
        return null;
    }
}
