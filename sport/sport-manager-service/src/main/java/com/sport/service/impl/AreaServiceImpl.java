package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.AreaDao;
import com.sport.model.Area;
import com.sport.service.interf.IAreaService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("areaService")
@Transactional(readOnly = true)
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaDao areaDao;
	/**
	 * 增加地区
	 * @param area
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addArea(Area area) throws Exception {
    	areaDao.addArea(area);
    }  
    /**
     * 根据主键查找地区
     * @param id
     * @return
     * @throws Exception 
     */
    public Area getAreaById(long id) throws Exception {
    	Area area = new Area();
    	area.setId(id);
        return areaDao.getAreaById(area);
    }  
    /**
     * 更新地区
     * @param area
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateArea(Area area) throws Exception {
    	areaDao.updateArea(area);
    }  
    /**
     * 删除地区
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteArea(long id) throws Exception {
    	Area area = new Area();
    	area.setId(id);
        areaDao.deleteArea(area);
    }  
    /**
     * 查询地区
     * @param area
     * @return
     * @throws Exception 
     */
    public List<Area> findAreas(Area area) throws Exception{
    	return areaDao.findAreas(area);
    }
    /**
     * 统计地区记录数
     * @param area
     * @return
     * @throws Exception 
     */
    public int countAreas(Area area) throws Exception{
    	return areaDao.countAreas(area);
    }
    /**
     * 获取最大地区编号
     * @param area
     * @return
     * @throws Exception 
     */
    public String maxAreas(Area area) throws Exception{
    	return areaDao.maxAreas(area);
    }
}  
