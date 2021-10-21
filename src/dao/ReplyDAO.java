package dao;

import dto.ReplyDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAO {

    private static ReplyDAO instance = new ReplyDAO();

    public static ReplyDAO getInstance() {return instance;};

    private Connection getConnection() throws Exception{
        Context init = new InitialContext();
        DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/orcl");
        return ds.getConnection();
    }

    public void insertReply(ReplyDTO dto){
        System.out.println("insertReply method");

        Connection con = null;
        PreparedStatement pstmt = null;


        try {
            con = getConnection();

            String sql = "insert into ex_reply values(seq_reply_no.nextval, ?, ?, sysdate, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,dto.getCos_name());
            pstmt.setString(2, dto.getId());
            pstmt.setString(3, dto.getReply_content());
            int result = pstmt.executeUpdate();
            System.out.println(result);

        } catch (Exception e) {
            System.out.println("insertReply : " + e);
            e.printStackTrace();
        }
    }



    public List<ReplyDTO> getReply(String cos_name){
        List<ReplyDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();

            String sql = "select * from ex_reply where cos_name = ? order by reply_no asc";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cos_name);
            rs = pstmt.executeQuery();

            while(rs.next()){
                ReplyDTO dto = new ReplyDTO();
                dto.setReply_no(rs.getInt("reply_no"));
                dto.setCos_name(rs.getString("cos_name"));
                dto.setId(rs.getString("id"));
                dto.setReply_date(rs.getTimestamp("reply_date"));
                dto.setReply_content(rs.getString("reply_content"));

                list.add(dto);
            }
        } catch (Exception e) {
            System.out.println("getReply : " + e);
            e.printStackTrace();
        }
        return list;
    }

}
