package com.spring.beans;

import java.util.List;

public class Employee {

	private int eid;
	private String ename;
	private String position;
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Employee(int eid, String ename, String position) {
		this.eid = eid;
		this.ename = ename;
		this.position = position;
	}

	public void perform() {
		System.out.println(ename + " has ID and position as " + eid + position);
		for (Address address : addresses) {
			System.out.println(ename + " lives at " + address.getCity());
		}

	}
}
