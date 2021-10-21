package dto;

import java.sql.Timestamp;

public class ReplyDTO {
    private int reply_no;
    private String cos_name;
    private String id;
    private Timestamp reply_date;
    private String reply_content;

    public int getReply_no() {
        return reply_no;
    }

    public void setReply_no(int reply_no) {
        this.reply_no = reply_no;
    }

    public String getCos_name() {
        return cos_name;
    }

    public void setCos_name(String cos_name) {
        this.cos_name = cos_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getReply_date() {
        return reply_date;
    }

    public void setReply_date(Timestamp reply_date) {
        this.reply_date = reply_date;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }
}
