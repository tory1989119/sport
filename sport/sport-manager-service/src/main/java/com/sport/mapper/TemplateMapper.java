package com.sport.mapper;

import java.util.List;

import com.sport.model.Template;

public interface TemplateMapper {  
  
    public void add(Template template) throws Exception;
  
    public Template get(Template template) throws Exception;
  
    public void update(Template template) throws Exception;
  
    public void delete(Template template) throws Exception;
  
    public List<Template> find(Template template) throws Exception;
    
    public int count(Template template) throws Exception;
}  