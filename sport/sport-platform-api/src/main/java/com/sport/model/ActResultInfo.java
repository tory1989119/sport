package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class ActResultInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public String tablename = "act_result_info";

	// columns START
	private long id;
	private long actId;
	private long matchId;
	private long personId;
	private String matchRank;
	private Date matchTime;
	private String matchRemark;
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

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(long matchId) {
		this.matchId = matchId;
	}

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getMatchRank() {
		return matchRank;
	}

	public void setMatchRank(String matchRank) {
		this.matchRank = matchRank;
	}

	public Date getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Date matchTime) {
		this.matchTime = matchTime;
	}

	public String getMatchRemark() {
		return matchRemark;
	}

	public void setMatchRemark(String matchRemark) {
		this.matchRemark = matchRemark;
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
