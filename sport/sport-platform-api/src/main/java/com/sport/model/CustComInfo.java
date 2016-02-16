package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class CustComInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tablename = "cust_com_info";

	private long id;
	private long acctId;
	private String comName;
	private String comEmail;
	private String comLicenseCode;
	private String comLicensePic;
	private String comMobile;
	private String comTel;
	private String comPerson;
	private String comAuthorizePic;
	private String comLogo;
	private String comRemark;
	private String comAddr;
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

	public String getComLicenseCode() {
		return comLicenseCode;
	}

	public void setComLicenseCode(String comLicenseCode) {
		this.comLicenseCode = comLicenseCode;
	}

	public String getComLicensePic() {
		return comLicensePic;
	}

	public void setComLicensePic(String comLicensePic) {
		this.comLicensePic = comLicensePic;
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

	public String getComPerson() {
		return comPerson;
	}

	public void setComPerson(String comPerson) {
		this.comPerson = comPerson;
	}

	public String getComAuthorizePic() {
		return comAuthorizePic;
	}

	public void setComAuthorizePic(String comAuthorizePic) {
		this.comAuthorizePic = comAuthorizePic;
	}

	public String getComLogo() {
		return comLogo;
	}

	public void setComLogo(String comLogo) {
		this.comLogo = comLogo;
	}

	public String getComRemark() {
		return comRemark;
	}

	public void setComRemark(String comRemark) {
		this.comRemark = comRemark;
	}

	public String getComAddr() {
		return comAddr;
	}

	public void setComAddr(String comAddr) {
		this.comAddr = comAddr;
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
