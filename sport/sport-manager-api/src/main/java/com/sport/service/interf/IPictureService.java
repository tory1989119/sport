package com.sport.service.interf;

import com.sport.model.Picture;
 
public interface IPictureService {
	/**
	 * 增加首页大图
	 * @param picture
	 * @throws Exception 
	 */
	public void addPicture(Picture picture) throws Exception;
    /**
     * 根据主键查找首页大图
     * @param userId
     * @return
     * @throws Exception 
     */
    public Picture getPictureById(long userId) throws Exception;
    /**
     * 更新首页大图
     * @param picture
     * @throws Exception 
     */
    public void updatePicture(Picture picture) throws Exception;
    /**
     * 删除首页大图
     * @param userId
     * @throws Exception 
     */
    public void deletePicture(long userId) throws Exception;
}
