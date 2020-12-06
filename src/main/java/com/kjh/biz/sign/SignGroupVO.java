package com.kjh.biz.sign;

/**
 * 결재자
 * */
public class SignGroupVO {
	private int doc_code; // 결재번호
	private String user_id; // 작성자아이디
	private String sign_id; // 결재자아이디
	private int sign_turn; // 결재순서
	private String sign_type; // 결재타입(합의, 결재)
	private int sign_status; // 결재상태(0 미결, 1 결재)
	
	public SignGroupVO() {
	}

	
	
	@Override
	public String toString() {
		return "SignGroupVO [doc_code=" + doc_code + ", user_id=" + user_id + ", sign_id=" + sign_id + ", sign_turn="
				+ sign_turn + ", sign_type=" + sign_type + ", sign_status=" + sign_status + "]";
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

	public String getSign_id() {
		return sign_id;
	}

	public void setSign_id(String sign_id) {
		this.sign_id = sign_id;
	}

	public int getSign_turn() {
		return sign_turn;
	}

	public void setSign_turn(int sign_turn) {
		this.sign_turn = sign_turn;
	}

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public int getSign_status() {
		return sign_status;
	}

	public void setSign_status(int sign_status) {
		this.sign_status = sign_status;
	}
	
}
