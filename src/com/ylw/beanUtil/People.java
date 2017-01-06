package com.ylw.beanUtil;

import java.util.Date;

public class People{
	private String name;
	private String id;
	private int age;
	private Date date;
	
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public People(String name, String id, int age, Date date) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.date = date;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", id=" + id + ", age=" + age
				+ ", date=" + date + "]";
	}
	
}
