package dto;

import java.sql.Date;

public class CommentBean 
{
	private int comment_num;		// ��� �۹�ȣ
	private String comment_board;		// �Խñ� ��ȣ
	private String comment_id;		// ��� �ۼ���
	private Date comment_date;		// ��� �ۼ���
	private int comment_parent;		// �θ��
	private String comment_content;	// ��� ����
	private int comment_level;		// ���- �亯�� ����
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public String getComment_board() {
		return comment_board;
	}
	public void setComment_board(String comment_board) {
		this.comment_board = comment_board;
	}
	public String getComment_id() {
		return comment_id;
	}
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public int getComment_parent() {
		return comment_parent;
	}
	public void setComment_parent(int comment_parent) {
		this.comment_parent = comment_parent;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public int getComment_level() {
		return comment_level;
	}
	public void setComment_level(int comment_level) {
		this.comment_level = comment_level;
	}
}
