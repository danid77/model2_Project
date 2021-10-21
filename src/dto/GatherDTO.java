package dto;

import java.sql.Timestamp;

public class GatherDTO {

	private int no;
	private String gathersubject;
	private String id;
	private String gatherpw;
	private String local;
	private String membercnt;
	private String content;
	private Timestamp reg_date;
	
	public int getNo() {
		return no;
	}
	public String getGathersubject() {
		return gathersubject;
	}
	public String getId() {
		return id;
	}
	public String getGatherpw() {
		return gatherpw;
	}
	public String getLocal() {
		return local;
	}
	public String getMembercnt() {
		return membercnt;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getReg_date() {
		return reg_date;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setGathersubject(String gathersubject) {
		this.gathersubject = gathersubject;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGatherpw(String gatherpw) {
		this.gatherpw = gatherpw;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setMembercnt(String membercnt) {
		this.membercnt = membercnt;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	
}
