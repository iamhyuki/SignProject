package com.kjh.biz.sign;

/**
 * 결재문서
 * */
public class SignDocVO {
	private int doc_code; // 결재번호
	private String user_id; // 작성자아이디
	private String name; // 작성자이름
	private String title; // 제목
	private String content; // 내용
	private String writedate; // 작성일자
	private int sign_turn; // 결재순서
	private int doc_status; // 문서상태(0 임시저장, 1 대기중, 2 심사중, 3 반려, 4 결재완료)
	private String complete_date; // 결재완료일자

	public SignDocVO() {
	}

	public int getDoc_code() {
		return doc_code;
	}

	public void setDoc_code(int doc_code) {
		this.doc_code = doc_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWritedate() {
		return writedate;
	}

	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

	public int getSign_turn() {
		return sign_turn;
	}

	public void setSign_turn(int sign_turn) {
		this.sign_turn = sign_turn;
	}

	public int getDoc_status() {
		return doc_status;
	}

	public void setDoc_status(int doc_status) {
		this.doc_status = doc_status;
	}

	public String getComplete_date() {
		return complete_date;
	}

	public void setComplete_date(String complete_date) {
		this.complete_date = complete_date;
	}

	
	
}
