package com.csq.entity;

public class Happiness {

	private int id;
	private String city;
	private int num;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Happiness [id=" + id + ", city=" + city + ", num=" + num + "]";
	}
	
	
}
