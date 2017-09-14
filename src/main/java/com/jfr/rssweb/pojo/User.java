package com.jfr.rssweb.pojo;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String salt;
	private String gauth;

	public User() {
		// this.salt=用户名算法
		// this.gauth=盐算法；
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getGauth() {
		return gauth;
	}

	public void setGauth(String gauth) {
		this.gauth = gauth;
	}
	
}
