package com.sport.common.util;

import java.util.List;

public class PageUtil {
	private int draw;
	private int recordsFiltered;
	private int recordsTotal;
	private List data;
	
	public PageUtil(int draw,int recordsFiltered,int recordsTotal,List data) {
		setData(data);
		setDraw(draw);
		setRecordsFiltered(recordsFiltered);
		setRecordsTotal(recordsTotal);
	}
	
	public PageUtil() {
		
	}
	
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
}
