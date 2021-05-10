package com.spring.entity;

import javax.persistence.Table;



@Table(name="employee", schema="springdemo")
public class Entity {
	private int eid;
	private String ename;
	private String addresses;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAddresses() {
		return addresses;
	}
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}
	
}
