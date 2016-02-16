package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.DataDao;
import com.sport.model.Data;
import com.sport.service.interf.IDataService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("dataService")
@Transactional(readOnly = true)
public class DataServiceImpl implements IDataService {
    @Autowired
    private DataDao dataDao;
	/**
	 * 增加系统参数
	 * @param data
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addData(Data data) throws Exception {
    	dataDao.addData(data);
    }  
    /**
     * 根据主键查找系统参数
     * @param id
     * @return
     * @throws Exception 
     */  
    public Data getDataById(long id) throws Exception {
    	Data data = new Data();
    	data.setId(id);
        return dataDao.getDataById(data);
    }  
    /**
     * 更新系统参数
     * @param data
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateData(Data data) throws Exception {
    	dataDao.updateData(data);
    }  
    /**
     * 删除系统参数
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteData(long id) throws Exception {
    	Data data = new Data();
    	data.setId(id);
        dataDao.deleteData(data);
    }  
    /**
     * 查询系统参数
     * @param data
     * @return
     * @throws Exception 
     */
    public List<Data> findDatas(Data data) throws Exception{
    	return dataDao.findDatas(data);
    }
}  
