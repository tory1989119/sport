package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tablename = "t_sys_operator";

	private long id;
	private String name;
	private String sex;
	private String phone;
	private String address;
	private String email;
	private String loginname;
	private String password;
	private long roleid;
	private Date adate;

	private String startadate;
	private String endadate;

	private int start;
	private int length;

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	public String getStartadate() {
		return startadate;
	}

	public void setStartadate(String startadate) {
		this.startadate = startadate;
	}

	public String getEndadate() {
		return endadate;
	}

	public void setEndadate(String endadate) {
		this.endadate = endadate;
	}
}
