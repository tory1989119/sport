package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ReportDao;
import com.sport.mapper.ReportMapper;
import com.sport.model.Report;

@Repository
public class ReportDaoImpl implements ReportDao {
    @Autowired
    private ReportMapper reportMapper;
  
    /**
     * 增加举报
     * @param report
     * @throws Exception 
     */
	public void addReport(Report report) throws Exception{
		reportMapper.add(report);
	}
    /**
     * 根据主键查找举报
     * @param report
     * @return
     * @throws Exception 
     */
    public Report getReportById(Report report) throws Exception{
    	return reportMapper.get(report);
    }
    /**
     * 更新举报
     * @param report
     * @throws Exception 
     */
    public void updateReport(Report report) throws Exception{
    	reportMapper.update(report);
    }
    /**
     * 删除举报
     * @param report
     * @throws Exception 
     */
    public void deleteReport(Report report) throws Exception{
    	reportMapper.delete(report);
    }
    /**
     * 查找举报
     * @param report
     * @return
     * @throws Exception 
     */
    public List<Report> findReports(Report report) throws Exception{
    	return reportMapper.find(report);
    }
    /**
     * 统计举报记录数
     * @param report
     * @return
     * @throws Exception 
     */
    public int countReports(Report report) throws Exception{
    	return reportMapper.count(report);
    }
}  
