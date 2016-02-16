package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.TemplateDao;
import com.sport.mapper.TemplateMapper;
import com.sport.model.Template;

import org.springframework.stereotype.Repository;

@Repository
public class TemplateDaoImpl implements TemplateDao {
    @Autowired
    private TemplateMapper templateMapper;
  
	/**
	 * 增加活动模板
	 * @param template
	 * @throws Exception 
	 */
	public void addTemplate(Template template) throws Exception{
		templateMapper.add(template);
	} 
	/**
	 * 根据主键查找活动模板
	 * @param template
	 * @return
	 * @throws Exception 
	 */
    public Template getTemplateById(Template template) throws Exception{
    	return templateMapper.get(template);
    }
    /**
	 * 更新活动模板
	 * @param template
     * @throws Exception 
	 */
    public void updateTemplate(Template template) throws Exception{
    	templateMapper.update(template);
    }
    /**
	 * 删除活动模板
	 * @param template
     * @throws Exception 
	 */
    public void deleteTemplate(Template template) throws Exception{
    	templateMapper.delete(template);
    }
    /**
	 * 查询活动模板
	 * @param template
	 * @return
     * @throws Exception 
	 */
    public List<Template> findTemplates(Template template) throws Exception{
    	return templateMapper.find(template);
    }
    /**
	 * 统计活动模板记录数
	 * @param template
	 * @return
     * @throws Exception 
	 */
    public int countTemplates(Template template) throws Exception{
    	return templateMapper.count(template);
    }
}  
