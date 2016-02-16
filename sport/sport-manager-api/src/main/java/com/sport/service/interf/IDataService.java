package com.sport.service.interf;

import java.util.List;

import com.sport.model.Data;
 
public interface IDataService {
	/**
	 * 增加系统参数
	 * @param data
	 * @throws Exception 
	 */
	public void addData(Data data) throws Exception;
    /**
     * 根据主键查找系统参数
     * @param id
     * @return
     * @throws Exception 
     */
    public Data getDataById(long id) throws Exception;
    /**
     * 更新系统参数
     * @param data
     * @throws Exception 
     */
    public void updateData(Data data) throws Exception;
    /**
     * 删除系统参数
     * @param id
     * @throws Exception 
     */
    public void deleteData(long id) throws Exception;
    /**
     * 查询系统参数
     * @param data
     * @return
     * @throws Exception 
     */
    public List<Data> findDatas(Data data) throws Exception;
}
