package com.sport.dao;

import java.util.List;

import com.sport.model.Report;
 
public interface ReportDao {
    /**
     * 增加举报
     * @param report
     * @throws Exception 
     */
	public void addReport(Report report) throws Exception;
    /**
     * 根据主键查找举报
     * @param report
     * @return
     * @throws Exception 
     */
    public Report getReportById(Report report) throws Exception;
    /**
     * 更新举报
     * @param report
     * @throws Exception 
     */
    public void updateReport(Report report) throws Exception;
    /**
     * 删除举报
     * @param report
     * @throws Exception 
     */
    public void deleteReport(Report report) throws Exception;
    /**
     * 查找举报
     * @param report
     * @return
     * @throws Exception 
     */
    public List<Report> findReports(Report report) throws Exception;
    /**
     * 统计举报记录数
     * @param report
     * @return
     * @throws Exception 
     */
    public int countReports(Report report) throws Exception;
}
