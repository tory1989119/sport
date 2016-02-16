package com.sport.dao;

import com.sport.model.Picture;
 
public interface PictureDao {
	/**
	 * 增加首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
	public void addPicture(Picture picture) throws Exception;
	/**
	 * 根据主键获取首页大图设置
	 * @param picture
	 * @return
	 * @throws Exception 
	 */ 
    public Picture getPictureById(Picture picture) throws Exception;
	/**
	 * 更新首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
    public void updatePicture(Picture picture) throws Exception;
	/**
	 * 删除首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
    public void deletePicture(Picture picture) throws Exception;
}
