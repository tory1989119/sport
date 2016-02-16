package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.CategoryDao;
import com.sport.mapper.CategoryMapper;
import com.sport.model.Category;

import org.springframework.stereotype.Repository;

 
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    private CategoryMapper categoryMapper;
	/**
	 * 增加活动分类
	 * @param category
	 * @throws Exception 
	 */
    public void addCategory(Category category) throws Exception {
    	categoryMapper.add(category);
    }  
    /**
     * 根据主键查找活动分类
     * @param category
     * @return
     * @throws Exception 
     */
    public Category getCategoryById(Category category) throws Exception {
        return categoryMapper.get(category);
    }  
    /**
     * 更新活动分类
     * @param category
     * @throws Exception 
     */
    public void updateCategory(Category category) throws Exception {
    	categoryMapper.update(category);
    }  
    /**
     * 删除活动分类
     * @param category
     * @throws Exception 
     */
    public void deleteCategory(Category category) throws Exception {
        categoryMapper.delete(category);
    }  
    /**
     * 查找活动分类
     * @param category
     * @return
     * @throws Exception 
     */
    public List<Category> findCategorys(Category category) throws Exception{
    	return categoryMapper.find(category);
    }
    /**
     * 统计活动分类记录数
     * @param category
     * @return
     * @throws Exception 
     */
    public int countCategorys(Category category) throws Exception{
    	return categoryMapper.count(category);
    }
    /**
     * 查找活动分类最大编号
     * @param category
     * @return
     * @throws Exception 
     */
    public String maxCategorys(Category category) throws Exception{
    	return categoryMapper.max(category);
    }
}  
