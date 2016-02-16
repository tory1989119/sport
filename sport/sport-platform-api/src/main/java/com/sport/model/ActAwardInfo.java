package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class ActAwardInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	public String tablename = "act_award_info";

	// columns START
	private long id;
	private long actId;
	private String awardName;
	private String awardRank;
	private long personId;
	private String awardStatus;
	private Date awardTime;

	// columns END

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getActId() {
		return actId;
	}

	public void setActId(long actId) {
		this.actId = actId;
	}

	public String getAwardName() {
		return awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getAwardRank() {
		return awardRank;
	}

	public void setAwardRank(String awardRank) {
		this.awardRank = awardRank;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getAwardStatus() {
		return awardStatus;
	}

	public void setAwardStatus(String awardStatus) {
		this.awardStatus = awardStatus;
	}

	public Date getAwardTime() {
		return awardTime;
	}

	public void setAwardTime(Date awardTime) {
		this.awardTime = awardTime;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
}
