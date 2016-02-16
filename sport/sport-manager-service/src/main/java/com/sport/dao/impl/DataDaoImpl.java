package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.DataDao;
import com.sport.mapper.DataMapper;
import com.sport.model.Data;

import org.springframework.stereotype.Repository;

 
@Repository
public class DataDaoImpl implements DataDao {
    @Autowired
    private DataMapper dataMapper;
	/**
	 * 增加系统参数
	 * @param data
	 * @throws Exception 
	 */
    public void addData(Data data) throws Exception {
    	dataMapper.add(data);
    }  
    /**
     * 根据主键查找系统惨呼
     * @param data
     * @return
     * @throws Exception 
     */
    public Data getDataById(Data data) throws Exception {
        return dataMapper.get(data);
    }  
    /**
     * 更新系统参数
     * @param data
     * @throws Exception 
     */
    public void updateData(Data data) throws Exception {
    	dataMapper.update(data);
    }  
    /**
     * 删除系统参数
     * @param data
     * @throws Exception 
     */
    public void deleteData(Data data) throws Exception {
        dataMapper.delete(data);
    }  
    /**
     * 查找系统参数
     * @param data
     * @return
     * @throws Exception 
     */
    public List<Data> findDatas(Data data) throws Exception{
    	return dataMapper.find(data);
    }
}  
