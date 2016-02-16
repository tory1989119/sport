package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.CategoryDao;
import com.sport.model.Category;
import com.sport.service.interf.ICategoryService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("categoryService")
@Transactional(readOnly = true)
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryDao categoryDao;
	/**
	 * 增加活动分类
	 * @param category
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addCategory(Category category) throws Exception {
    	categoryDao.addCategory(category);
    }  
    /**
     * 根据主键查找活动分类
     * @param id
     * @return
     * @throws Exception 
     */ 
    public Category getCategoryById(long id) throws Exception {
    	Category category = new Category();
    	category.setId(id);
        return categoryDao.getCategoryById(category);
    }  
    /**
     * 更新活动分类
     * @param category
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateCategory(Category category) throws Exception {
    	categoryDao.updateCategory(category);
    }  
    /**
     * 删除活动分类
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteCategory(long id) throws Exception {
    	Category category = new Category();
    	category.setId(id);
        categoryDao.deleteCategory(category);
    }  
    /**
     * 查询活动分类
     * @param category
     * @return
     * @throws Exception 
     */
    public List<Category> findCategorys(Category category) throws Exception{
    	return categoryDao.findCategorys(category);
    }
    /**
     * 统计活动分类记录数
     * @param category
     * @return
     * @throws Exception 
     */
    public int countCategorys(Category category) throws Exception{
    	return categoryDao.countCategorys(category);
    }
    /**
     * 查找活动分类最大编号
     * @param category
     * @return
     * @throws Exception 
     */
    public String maxCategorys(Category category) throws Exception{
    	return categoryDao.maxCategorys(category);
    }
}  
