package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class ActBaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	public String tablename = "act_base_info";

	private long id;
	private long comId;
	private String comName;
	private String actName;
	private String actTitle;
	private String actThemePc;
	private String actThemeMobile;
	private String joinRule;
	private double joinCost;
	private String joinCostUnit;
	private Date joinStart;
	private Date joinEnd;
	private Date holdStart;
	private Date holdEnd;
	private String actPerson;
	private String actPersonMobile;
	private String actContractor;
	private String actSponsor;
	private int actPersonNumber;
	private String actRemark;
	private String reward;
	private String actAddr;
	private Date createTime;
	private String actStatus;

	private String startcreatetime;
	private String endcreatetime;

	private String strjoinstart;
	private String strjoinend;
	private String strholdstart;
	private String strholdend;

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

	public long getComId() {
		return comId;
	}

	public void setComId(long comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActTitle() {
		return actTitle;
	}

	public void setActTitle(String actTitle) {
		this.actTitle = actTitle;
	}

	public String getActThemePc() {
		return actThemePc;
	}

	public void setActThemePc(String actThemePc) {
		this.actThemePc = actThemePc;
	}

	public String getActThemeMobile() {
		return actThemeMobile;
	}

	public void setActThemeMobile(String actThemeMobile) {
		this.actThemeMobile = actThemeMobile;
	}

	public String getJoinRule() {
		return joinRule;
	}

	public void setJoinRule(String joinRule) {
		this.joinRule = joinRule;
	}

	public double getJoinCost() {
		return joinCost;
	}

	public void setJoinCost(double joinCost) {
		this.joinCost = joinCost;
	}

	public String getJoinCostUnit() {
		return joinCostUnit;
	}

	public void setJoinCostUnit(String joinCostUnit) {
		this.joinCostUnit = joinCostUnit;
	}

	public Date getJoinStart() {
		return joinStart;
	}

	public void setJoinStart(Date joinStart) {
		this.joinStart = joinStart;
	}

	public Date getJoinEnd() {
		return joinEnd;
	}

	public void setJoinEnd(Date joinEnd) {
		this.joinEnd = joinEnd;
	}

	public Date getHoldStart() {
		return holdStart;
	}

	public void setHoldStart(Date holdStart) {
		this.holdStart = holdStart;
	}

	public Date getHoldEnd() {
		return holdEnd;
	}

	public void setHoldEnd(Date holdEnd) {
		this.holdEnd = holdEnd;
	}

	public String getActPerson() {
		return actPerson;
	}

	public void setActPerson(String actPerson) {
		this.actPerson = actPerson;
	}

	public String getActPersonMobile() {
		return actPersonMobile;
	}

	public void setActPersonMobile(String actPersonMobile) {
		this.actPersonMobile = actPersonMobile;
	}

	public String getActContractor() {
		return actContractor;
	}

	public void setActContractor(String actContractor) {
		this.actContractor = actContractor;
	}

	public String getActSponsor() {
		return actSponsor;
	}

	public void setActSponsor(String actSponsor) {
		this.actSponsor = actSponsor;
	}

	public int getActPersonNumber() {
		return actPersonNumber;
	}

	public void setActPersonNumber(int actPersonNumber) {
		this.actPersonNumber = actPersonNumber;
	}

	public String getActRemark() {
		return actRemark;
	}

	public void setActRemark(String actRemark) {
		this.actRemark = actRemark;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getActAddr() {
		return actAddr;
	}

	public void setActAddr(String actAddr) {
		this.actAddr = actAddr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getActStatus() {
		return actStatus;
	}

	public void setActStatus(String actStatus) {
		this.actStatus = actStatus;
	}

	public String getStartcreatetime() {
		return startcreatetime;
	}

	public void setStartcreatetime(String startcreatetime) {
		this.startcreatetime = startcreatetime;
	}

	public String getEndcreatetime() {
		return endcreatetime;
	}

	public void setEndcreatetime(String endcreatetime) {
		this.endcreatetime = endcreatetime;
	}

	public String getStrjoinstart() {
		return strjoinstart;
	}

	public void setStrjoinstart(String strjoinstart) {
		this.strjoinstart = strjoinstart;
	}

	public String getStrjoinend() {
		return strjoinend;
	}

	public void setStrjoinend(String strjoinend) {
		this.strjoinend = strjoinend;
	}

	public String getStrholdstart() {
		return strholdstart;
	}

	public void setStrholdstart(String strholdstart) {
		this.strholdstart = strholdstart;
	}

	public String getStrholdend() {
		return strholdend;
	}

	public void setStrholdend(String strholdend) {
		this.strholdend = strholdend;
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
	
}
