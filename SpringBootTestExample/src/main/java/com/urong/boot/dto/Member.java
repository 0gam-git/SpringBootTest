package com.urong.boot.dto;

public class Member {

	private int idx;
	private String email;
	private String name;

	public Member() {
	}

	public Member(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
