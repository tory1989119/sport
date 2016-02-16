package com.sport.dao;

import java.util.List;

import com.sport.model.Template;
 
public interface TemplateDao {
	/**
	 * 增加活动模板
	 * @param template
	 * @throws Exception 
	 */
	public void addTemplate(Template template) throws Exception;
	/**
	 * 根据主键查找活动模板
	 * @param template
	 * @return
	 * @throws Exception 
	 */
    public Template getTemplateById(Template template) throws Exception;
    /**
	 * 更新活动模板
	 * @param template
     * @throws Exception 
	 */
    public void updateTemplate(Template template) throws Exception;
    /**
	 * 删除活动模板
	 * @param template
     * @throws Exception 
	 */
    public void deleteTemplate(Template template) throws Exception;
    /**
	 * 查询活动模板
	 * @param template
	 * @return
     * @throws Exception 
	 */
    public List<Template> findTemplates(Template template) throws Exception;
    /**
	 * 统计活动模板记录数
	 * @param template
	 * @return
     * @throws Exception 
	 */
    public int countTemplates(Template template) throws Exception;
}
