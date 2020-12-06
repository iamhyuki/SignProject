package com.kjh.biz.etc;

public class SignGroupListVO {
	private String sign_id; // 결재자아이디
	private	String name; // 결재자이름
	private String rank; // 결재자직급
	private int sign_turn; // 결재순서
	private String sign_type; // 결재타입(합의 or 결재)
	private int sign_status; // 결재상태(0 미결, 1 결재)
	
	public SignGroupListVO() {

	}

	public String getSign_id() {
		return sign_id;
	}

	public void setSign_id(String sign_id) {
		this.sign_id = sign_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
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
