package com.kjh.biz.sign;

import org.springframework.web.multipart.MultipartFile;

/**
 *  결재 첨부파일
 * */
public class SignFileVO {
	private int doc_code; // 결재번호
	private String orgname; // 파일원본이름
	private String sysname; // 파일시스템이름
	private char del_flag; // 파일삭제구분 default 'N'
	
	private MultipartFile[] uploadFile;
	
	public SignFileVO() {
	}
	
	@Override
	public String toString() {
		return "SignFileVO [doc_code=" + doc_code + ", orgname=" + orgname + ", sysname=" + sysname + "]";
	}

	public int getDoc_code() {
		return doc_code;
	}

	public void setDoc_code(int doc_code) {
		this.doc_code = doc_code;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	
	public char getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(char del_flag) {
		this.del_flag = del_flag;
	}

	public MultipartFile[] getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile[] uploadFile) {
		this.uploadFile = uploadFile;
	}

	
	
}
