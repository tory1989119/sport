package com.sport.service.interf;

import java.util.List;

import com.sport.model.Area;
 
public interface IAreaService {  
	/**
	 * 增加地区
	 * @param area
	 * @throws Exception 
	 */
	public void addArea(Area area) throws Exception;
    /**
     * 根据主键查找地区
     * @param id
     * @return
     * @throws Exception 
     */
    public Area getAreaById(long id) throws Exception;
    /**
     * 更新地区
     * @param area
     * @throws Exception 
     */
    public void updateArea(Area area) throws Exception;
    /**
     * 删除地区
     * @param id
     * @throws Exception 
     */
    public void deleteArea(long id) throws Exception;
    /**
     * 查询地区
     * @param area
     * @return
     * @throws Exception 
     */
    public List<Area> findAreas(Area area) throws Exception;
    /**
     * 统计地区记录数
     * @param area
     * @return
     * @throws Exception 
     */
    public int countAreas(Area area) throws Exception;
    /**
     * 获取最大地区编号
     * @param area
     * @return
     * @throws Exception 
     */
    public String maxAreas(Area area) throws Exception;
}
