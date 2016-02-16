package com.sport.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.PictureDao;
import com.sport.mapper.PictureMapper;
import com.sport.model.Picture;

import org.springframework.stereotype.Repository;
 
@Repository
public class PictureDaoImpl implements PictureDao {
    @Autowired
    private PictureMapper pictureMapper;
  
	/**
	 * 增加首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
	public void addPicture(Picture picture) throws Exception{
		pictureMapper.add(picture);
	}
	/**
	 * 根据主键获取首页大图设置
	 * @param picture
	 * @return
	 * @throws Exception 
	 */ 
    public Picture getPictureById(Picture picture) throws Exception{
    	return pictureMapper.get(picture);
    }
	/**
	 * 更新首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
    public void updatePicture(Picture picture) throws Exception{
    	pictureMapper.update(picture);
    }
	/**
	 * 删除首页大图设置
	 * @param picture
	 * @throws Exception 
	 */
    public void deletePicture(Picture picture) throws Exception{
    	pictureMapper.delete(picture);
    }
}  
