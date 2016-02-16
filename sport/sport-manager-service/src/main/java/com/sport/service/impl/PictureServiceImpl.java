package com.sport.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.PictureDao;
import com.sport.model.Picture;
import com.sport.service.interf.IPictureService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("pictureService")
@Transactional(readOnly = true)
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private PictureDao pictureDao;
	/**
	 * 增加首页大图
	 * @param picture
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addPicture(Picture picture) throws Exception {
    	pictureDao.addPicture(picture);
    }  
    /**
     * 根据主键查找首页大图
     * @param userId
     * @return
     * @throws Exception 
     */
    @Override  
    public Picture getPictureById(long id) throws Exception {
    	Picture picture = new Picture();
    	picture.setId(id);
        return pictureDao.getPictureById(picture);
    }  
    /**
     * 更新首页大图
     * @param picture
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updatePicture(Picture picture) throws Exception {
    	pictureDao.updatePicture(picture);
    }  
    /**
     * 删除首页大图
     * @param userId
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deletePicture(long id) throws Exception {
    	Picture picture = new Picture();
    	picture.setId(id);
    	pictureDao.deletePicture(picture);
    }  
}  
