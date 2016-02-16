package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class CustPersonInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tablename = "cust_person_info";

	private long id;
	private long acctId;
	private String realName;
	private String cardId;
	private String perEmail;
	private String perTel;
	private String perMobile;
	private String perSex;
	private String perWechat;
	private String perQq;
	private String perHobby;
	private int perAge;
	private String perAddr;
	private Date regTime;

	private String startregtime;
	private String endregtime;

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

	public long getAcctId() {
		return acctId;
	}

	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPerEmail() {
		return perEmail;
	}

	public void setPerEmail(String perEmail) {
		this.perEmail = perEmail;
	}

	public String getPerTel() {
		return perTel;
	}

	public void setPerTel(String perTel) {
		this.perTel = perTel;
	}

	public String getPerMobile() {
		return perMobile;
	}

	public void setPerMobile(String perMobile) {
		this.perMobile = perMobile;
	}

	public String getPerSex() {
		return perSex;
	}

	public void setPerSex(String perSex) {
		this.perSex = perSex;
	}

	public String getPerWechat() {
		return perWechat;
	}

	public void setPerWechat(String perWechat) {
		this.perWechat = perWechat;
	}

	public String getPerQq() {
		return perQq;
	}

	public void setPerQq(String perQq) {
		this.perQq = perQq;
	}

	public String getPerHobby() {
		return perHobby;
	}

	public void setPerHobby(String perHobby) {
		this.perHobby = perHobby;
	}

	public int getPerAge() {
		return perAge;
	}

	public void setPerAge(int perAge) {
		this.perAge = perAge;
	}

	public String getPerAddr() {
		return perAddr;
	}

	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public String getStartregtime() {
		return startregtime;
	}

	public void setStartregtime(String startregtime) {
		this.startregtime = startregtime;
	}

	public String getEndregtime() {
		return endregtime;
	}

	public void setEndregtime(String endregtime) {
		this.endregtime = endregtime;
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
