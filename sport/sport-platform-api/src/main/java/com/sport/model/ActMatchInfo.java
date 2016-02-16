package com.sport.model;

import java.io.Serializable;

public class ActMatchInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public String tablename = "act_match_info";

	// columns START
	private long id;
	private long actId;
	private String actCode;
	private String actName;
	private String matchName;
	private String matchRule;
	private String matchRemark;
	private String matchLevel1;
	private String matchLevel2;
	private String matchLevel3;
	private String reward;

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

	public String getActCode() {
		return actCode;
	}

	public void setActCode(String actCode) {
		this.actCode = actCode;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

	public String getMatchRule() {
		return matchRule;
	}

	public void setMatchRule(String matchRule) {
		this.matchRule = matchRule;
	}

	public String getMatchRemark() {
		return matchRemark;
	}

	public void setMatchRemark(String matchRemark) {
		this.matchRemark = matchRemark;
	}

	public String getMatchLevel1() {
		return matchLevel1;
	}

	public void setMatchLevel1(String matchLevel1) {
		this.matchLevel1 = matchLevel1;
	}

	public String getMatchLevel2() {
		return matchLevel2;
	}

	public void setMatchLevel2(String matchLevel2) {
		this.matchLevel2 = matchLevel2;
	}

	public String getMatchLevel3() {
		return matchLevel3;
	}

	public void setMatchLevel3(String matchLevel3) {
		this.matchLevel3 = matchLevel3;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
}
