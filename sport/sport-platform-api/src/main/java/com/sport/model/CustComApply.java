package com.sport.model;

import java.io.Serializable;
import java.util.Date;

public class CustComApply implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tablename = "cust_com_apply";

	private long id;
	private long acctId;
	private long comId;
	private Date applyDate;
	private String applyStatus;
	private String note;
	private String comLicensePic;
	private String comAuthorizePic;
	private String comLogo;

	private String startapplydate;
	private String endapplydate;

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

	public long getComId() {
		return comId;
	}

	public void setComId(long comId) {
		this.comId = comId;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getComLicensePic() {
		return comLicensePic;
	}

	public void setComLicensePic(String comLicensePic) {
		this.comLicensePic = comLicensePic;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getStartapplydate() {
		return startapplydate;
	}

	public void setStartapplydate(String startapplydate) {
		this.startapplydate = startapplydate;
	}

	public String getEndapplydate() {
		return endapplydate;
	}

	public void setEndapplydate(String endapplydate) {
		this.endapplydate = endapplydate;
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
