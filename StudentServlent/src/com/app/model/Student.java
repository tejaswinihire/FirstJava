package com.app.model;

import java.io.Serializable;

public class Student implements Serializable {
	private int Prn;
	private String name;
	private int s1,s2,s3;
	public int getPrn() {
		return Prn;
	}
	public void setPrn(int prn) {
		Prn = prn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getS1() {
		return s1;
	}
	public void setS1(int s1) {
		this.s1 = s1;
	}
	public int getS2() {
		return s2;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}
	public int getS3() {
		return s3;
	}
	public void setS3(int s3) {
		this.s3 = s3;
	}
	
	
	
	

}
