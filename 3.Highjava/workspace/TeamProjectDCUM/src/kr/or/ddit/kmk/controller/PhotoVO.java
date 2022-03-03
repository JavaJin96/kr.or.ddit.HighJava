package kr.or.ddit.kmk.controller;

// 파일 정보가 저장될 VO객체
public class PhotoVO {
	
	private String photoName;	 // 파일이름
	private long photoSize;		 // 파일크기
	private String uploadStatus; // Upload성공여부 
	
	public String getphotoName() {
		return photoName;
	}
	public void setphotoName(String photoName) {
		this.photoName = photoName;
	}
	public long getphotoSize() {
		return photoSize;
	}
	public void setphotoSize(long photoSize) {
		this.photoSize = photoSize;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
}
