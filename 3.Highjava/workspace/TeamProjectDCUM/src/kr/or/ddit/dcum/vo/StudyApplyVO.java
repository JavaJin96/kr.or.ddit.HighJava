package kr.or.ddit.dcum.vo;

public class StudyApplyVO {
	
	public String sb_num;
	public String mem_id;
	public String mem_name;
	public String mem_gender;
	public String dep_name;
	
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	
	public String getSb_num() {
		return sb_num;
	}
	public void setSb_num(String sb_num) {
		this.sb_num = sb_num;
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

}
