package com.knr.springapp.vo;

/*
 * create table emp_users (
user_id varchar2(50) primary key,
password varchar2(256) not null,
name varchar2(50) not null,
tel varchar2(20) null,
picture BLOB null,
picture_size varchar2 (4000) null
);

 */
public class UserVO {
	private String userId;
	private String password;
	private String name;
	private String tel;
	private byte[] picture;
	private long pictureSize;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public long getPictureSize() {
		return pictureSize;
	}

	public void setPictureSize(long pictureSize) {
		this.pictureSize = pictureSize;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", password=" + password + ", name=" + name + ", tel=" + tel + ", picture="
				+ picture + ", pictureSize=" + pictureSize + "]";
	}

}
