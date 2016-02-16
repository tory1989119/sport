package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class Picture implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tablename = "t_sys_picture";

	private long id;
	private String url;
	private Date adate;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}
}
