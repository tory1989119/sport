package com.sport.model;

import java.io.Serializable;

public class SessionInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long acctId;
	private String acctStatus;
	private String acctType;
	
	private long personId;
	private String realName;
	private String perEmail;
	private String perTel;
	private String perMobile;
	private String perSex;
	
	private long comId;
	private String comName;
	private String comEmail;
	private String comMobile;
	private String comTel;
	public long getAcctId() {
		return acctId;
	}
	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}
	public String getAcctStatus() {
		return acctStatus;
	}
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
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
	public String getComEmail() {
		return comEmail;
	}
	public void setComEmail(String comEmail) {
		this.comEmail = comEmail;
	}
	public String getComMobile() {
		return comMobile;
	}
	public void setComMobile(String comMobile) {
		this.comMobile = comMobile;
	}
	public String getComTel() {
		return comTel;
	}
	public void setComTel(String comTel) {
		this.comTel = comTel;
	}
	
}
