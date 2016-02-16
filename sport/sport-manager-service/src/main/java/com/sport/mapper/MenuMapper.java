package com.sport.mapper;

import java.util.List;

import com.sport.model.Menu;

public interface MenuMapper {  
  
    public void add(Menu menu) throws Exception;
  
    public Menu get(Menu menu) throws Exception;
  
    public void update(Menu menu) throws Exception;
  
    public void delete(Menu menu) throws Exception;
  
    public List<Menu> find(Menu menu) throws Exception;
}  