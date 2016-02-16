package com.sport.dao;

import java.util.List;

import com.sport.model.Category;
 
public interface CategoryDao {
	/**
	 * 增加活动分类
	 * @param category
	 * @throws Exception 
	 */
	public void addCategory(Category category) throws Exception;
    /**
     * 根据主键查找活动分类
     * @param category
     * @return
     * @throws Exception 
     */
    public Category getCategoryById(Category category) throws Exception;
    /**
     * 更新活动分类
     * @param category
     * @throws Exception 
     */
    public void updateCategory(Category category) throws Exception;
    /**
     * 删除活动分类
     * @param category
     * @throws Exception 
     */
    public void deleteCategory(Category category) throws Exception;
    /**
     * 查找活动分类
     * @param category
     * @return
     * @throws Exception 
     */
    public List<Category> findCategorys(Category category) throws Exception;
    /**
     * 统计活动分类记录数
     * @param category
     * @return
     * @throws Exception 
     */
    public int countCategorys(Category category) throws Exception;
    /**
     * 查找活动分类最大编号
     * @param category
     * @return
     * @throws Exception 
     */
    public String maxCategorys(Category category) throws Exception;
}
