package dto;

public class PeopleDTO {

	private int no;
	private String gather_name;
	private String id;
	private String local;
	private String gender;
	
	public int getNo() {
		return no;
	}
	public String getGather_name() {
		return gather_name;
	}
	public String getId() {
		return id;
	}
	public String getLocal() {
		return local;
	}
	public String getGender() {
		return gender;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setGather_name(String gather_name) {
		this.gather_name = gather_name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
