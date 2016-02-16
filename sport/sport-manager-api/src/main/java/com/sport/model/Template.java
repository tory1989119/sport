package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	private String tablename = "t_sys_template";

	private long id;
	private String name;
	private String pagename;
	private String url;
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

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
}
