package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tablename = "t_sys_role";

	private long id;
	private String rolename;
	private String authority;
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

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
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
