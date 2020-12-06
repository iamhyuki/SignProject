package com.kjh.biz.user;

/**
 * 사용자
 * */
public class UserVO {
	private int user_code; // 사용자코드
	private String user_id; //  아이디
	private String user_pw; // 비밀번호
	private String name; // 이름
	private String phone; // 전화번호
	private String rank; // 직급
	private String ins_date; // 입사일자
	
	public UserVO() {

	}

	
	
	@Override
	public String toString() {
		return "UsersVO [user_code=" + user_code + ", user_id=" + user_id + ", user_pw=" + user_pw + ", name=" + name
				+ ", phone=" + phone + ", rank=" + rank + ", ins_date=" + ins_date + "]";
	}



	public int getUser_code() {
		return user_code;
	}

	public void setUser_code(int user_code) {
		this.user_code = user_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getIns_date() {
		return ins_date;
	}

	public void setIns_date(String ins_date) {
		this.ins_date = ins_date;
	}
	
	
}
