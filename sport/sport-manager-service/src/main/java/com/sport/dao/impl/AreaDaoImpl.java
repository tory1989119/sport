package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.AreaDao;
import com.sport.mapper.AreaMapper;
import com.sport.model.Area;

 
@Repository
public class AreaDaoImpl implements AreaDao {
    @Autowired
    private AreaMapper areaMapper;
	/**
	 * 添加地区
	 * @param area
	 * @throws Exception 
	 */
    public void addArea(Area area) throws Exception {
    	areaMapper.add(area);
    }  
    /**
     * 根据主键获取地区
     * @param area
     * @return
     * @throws Exception 
     */
    public Area getAreaById(Area area) throws Exception {
        return areaMapper.get(area);
    }  
    /**
     * 更新地区
     * @param area
     * @throws Exception 
     */
    public void updateArea(Area area) throws Exception {
    	areaMapper.update(area);
    }  
    /**
     * 删除地区
     * @param area
     * @throws Exception 
     */
    public void deleteArea(Area area) throws Exception {
        areaMapper.delete(area);
    }  
    /**
     * 查找地区
     * @param area
     * @return
     * @throws Exception 
     */
    public List<Area> findAreas(Area area) throws Exception{
    	return areaMapper.find(area);
    }
    /**
     * 统计地区记录数
     * @param area
     * @return
     * @throws Exception 
     */
    public int countAreas(Area area) throws Exception{
    	return areaMapper.count(area);
    }
    /**
     * 获取最大地区编号
     * @param area
     * @return
     * @throws Exception 
     */
    public String maxAreas(Area area) throws Exception{
    	return areaMapper.max(area);
    }
}  
