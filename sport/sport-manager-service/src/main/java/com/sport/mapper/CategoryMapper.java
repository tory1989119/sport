package com.sport.mapper;

import java.util.List;

import com.sport.model.Category;

public interface CategoryMapper {  
  
    public void add(Category category) throws Exception;
  
    public Category get(Category category) throws Exception;
  
    public void update(Category category) throws Exception;
  
    public void delete(Category category) throws Exception;
  
    public List<Category> find(Category category) throws Exception;
    
    public int count(Category category) throws Exception;
    
    public String max(Category category) throws Exception;
}  