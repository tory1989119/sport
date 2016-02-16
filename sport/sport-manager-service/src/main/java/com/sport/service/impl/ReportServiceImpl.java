package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.ReportDao;
import com.sport.model.Report;
import com.sport.service.interf.IReportService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("reportService")
@Transactional(readOnly = true)
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportDao reportDao;
	/**
	 * 增加留言
	 * @param report
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addReport(Report report) throws Exception {
    	reportDao.addReport(report);
    }  
    /**
     * 根据主键查找留言
     * @param id
     * @return
     * @throws Exception 
     */
    public Report getReportById(long id) throws Exception {
    	Report report = new Report();
    	report.setId(id);
        return reportDao.getReportById(report);
    }  
    /**
     * 更新留言
     * @param report
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateReport(Report report) throws Exception {
    	reportDao.updateReport(report);
    }  
    /**
     * 删除留言
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteReport(long id) throws Exception {
    	Report report = new Report();
    	report.setId(id);
    	reportDao.deleteReport(report);
    }  
    /**
     * 查找留言
     * @param report
     * @return
     * @throws Exception 
     */
    public List<Report> findReports(Report report) throws Exception{
    	return reportDao.findReports(report);
    }
    /**
     * 统计留言记录数
     * @param report
     * @return
     * @throws Exception 
     */
    public int countReports(Report report) throws Exception{
    	return reportDao.countReports(report);
    }
}  
