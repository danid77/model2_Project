package service.cos;

import dao.ReplyDAO;
import dto.ReplyDTO;
import service.Action;
import service.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReplyWriteAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("utf-8");

        System.out.println("ReplyWriteAction.java");

        // 넘어온 데이터를 dto에 저장
        ReplyDTO dto = new ReplyDTO();
        dto.setCos_name(request.getParameter("cos_name"));
        dto.setId(request.getParameter("id"));
        dto.setReply_content(request.getParameter("reply_content"));

        // db 저장을 위한 dao에 데이터 전달
        ReplyDAO manager = ReplyDAO.getInstance();
        manager.insertReply(dto);

        return null;
    }
}


