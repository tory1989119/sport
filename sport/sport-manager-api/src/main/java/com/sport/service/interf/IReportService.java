package com.sport.service.interf;

import java.util.List;

import com.sport.model.Report;
 
public interface IReportService {
	/**
	 * 增加留言
	 * @param report
	 * @throws Exception 
	 */
	public void addReport(Report report) throws Exception;
    /**
     * 根据主键查找留言
     * @param id
     * @return
     * @throws Exception 
     */
    public Report getReportById(long id) throws Exception;
    /**
     * 更新留言
     * @param report
     * @throws Exception 
     */
    public void updateReport(Report report) throws Exception;
    /**
     * 删除留言
     * @param id
     * @throws Exception 
     */
    public void deleteReport(long id) throws Exception;
    /**
     * 查找留言
     * @param report
     * @return
     * @throws Exception 
     */
    public List<Report> findReports(Report report) throws Exception;
    /**
     * 统计留言记录数
     * @param report
     * @return
     * @throws Exception 
     */
    public int countReports(Report report) throws Exception;
}
