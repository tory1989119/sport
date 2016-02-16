package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.TemplateDao;
import com.sport.model.Template;
import com.sport.service.interf.ITemplateService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("templateService")
@Transactional(readOnly = true)
public class TemplateServiceImpl implements ITemplateService {
    @Autowired
    private TemplateDao templateDao;
	/**
	 * 增加活动模板
	 * @param template
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addTemplate(Template template) throws Exception {
    	templateDao.addTemplate(template);
    }  
    /**
     * 根据主键查找活动模板
     * @param id
     * @return
     * @throws Exception 
     */
    public Template getTemplateById(long id) throws Exception {
    	Template template = new Template();
    	template.setId(id);
        return templateDao.getTemplateById(template);
    }  
    /**
	 * 更新活动模板
	 * @param template
     * @throws Exception 
	 */
    @Transactional(readOnly = false)  
    public void updateTemplate(Template template) throws Exception {
    	templateDao.updateTemplate(template);
    }  
    /**
     * 删除活动模板
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteTemplate(long id) throws Exception {
    	Template template = new Template();
    	template.setId(id);
        templateDao.deleteTemplate(template);
    }  
    /**
	 * 查询活动模板
	 * @param template
     * @throws Exception 
	 */
    public List<Template> findTemplates(Template template) throws Exception{
    	return templateDao.findTemplates(template);
    }
    /**
	 * 统计活动模板记录数
	 * @param template
     * @throws Exception 
	 */
    public int countTemplates(Template template) throws Exception{
    	return templateDao.countTemplates(template);
    }
}  
