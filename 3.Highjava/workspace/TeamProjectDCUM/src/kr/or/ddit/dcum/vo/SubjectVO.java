package kr.or.ddit.dcum.vo;

public class SubjectVO {
 	private String sub_num  ;
	private String sub_name ;
	private int sub_cnt  ;
	private String mem_id   ;
	private String status; 
	
	
	public String getSub_num() {
		return sub_num;
	}
	public void setSub_num(String sub_num) {
		this.sub_num = sub_num;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getSub_cnt() {
		return sub_cnt;
	}
	public void setSub_cnt(int sub_cnt) {
		this.sub_cnt = sub_cnt;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
