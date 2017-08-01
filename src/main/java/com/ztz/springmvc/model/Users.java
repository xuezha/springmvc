package com.ztz.springmvc.model;

public class Users {
	private String name;
	private String password;
	//省略get set方法
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//重写toString()方便测试
	@Override
	public String toString() {
		return "Users [name=" + name + ", password=" + password +  "]";
	}
}
