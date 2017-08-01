package com.ztz.springmvc.model;

public class Roles {
	private int id;
	private String name;
	//省略get set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//重写toString()方便测试
	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + "]";
	}
}
