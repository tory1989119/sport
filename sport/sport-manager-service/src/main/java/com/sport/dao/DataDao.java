package com.sport.dao;

import java.util.List;

import com.sport.model.Data;
 
public interface DataDao {
	/**
	 * 增加系统参数
	 * @param data
	 * @throws Exception 
	 */
	public void addData(Data data) throws Exception;
    /**
     * 根据主键查找系统惨呼
     * @param data
     * @return
     * @throws Exception 
     */
    public Data getDataById(Data data) throws Exception;
    /**
     * 更新系统参数
     * @param data
     * @throws Exception 
     */
    public void updateData(Data data) throws Exception;
    /**
     * 删除系统参数
     * @param data
     * @throws Exception 
     */
    public void deleteData(Data data) throws Exception;
    /**
     * 查找系统参数
     * @param data
     * @return
     * @throws Exception 
     */
    public List<Data> findDatas(Data data) throws Exception;
}
