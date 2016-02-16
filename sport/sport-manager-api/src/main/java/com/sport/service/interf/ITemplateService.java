package com.sport.service.interf;

import java.util.List;

import com.sport.model.Template;
 
public interface ITemplateService {
	/**
	 * 增加活动模板
	 * @param template
	 * @throws Exception 
	 */
	public void addTemplate(Template template) throws Exception;
    /**
     * 根据主键查找活动模板
     * @param id
     * @return
     * @throws Exception 
     */
    public Template getTemplateById(long id) throws Exception;
    /**
	 * 更新活动模板
	 * @param template
     * @throws Exception 
	 */
    public void updateTemplate(Template template) throws Exception;
    /**
     * 删除活动模板
     * @param id
     * @throws Exception 
     */
    public void deleteTemplate(long id) throws Exception;
    /**
	 * 查询活动模板
	 * @param template
     * @throws Exception 
	 */
    public List<Template> findTemplates(Template template) throws Exception;
    /**
	 * 统计活动模板记录数
	 * @param template
     * @throws Exception 
	 */
    public int countTemplates(Template template) throws Exception;
}
