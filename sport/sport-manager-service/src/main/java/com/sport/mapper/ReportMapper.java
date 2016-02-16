package com.sport.mapper;

import java.util.List;

import com.sport.model.Report;

public interface ReportMapper {  
  
    public void add(Report report) throws Exception;
  
    public Report get(Report report) throws Exception;
  
    public void update(Report report) throws Exception;
  
    public void delete(Report report) throws Exception;
  
    public List<Report> find(Report report) throws Exception;
    
    public int count(Report report) throws Exception;
}  