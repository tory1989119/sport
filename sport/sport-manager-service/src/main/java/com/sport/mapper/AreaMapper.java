package com.sport.mapper;

import java.util.List;

import com.sport.model.Area;

public interface AreaMapper {  
  
    public void add(Area area) throws Exception;
  
    public Area get(Area area) throws Exception;
  
    public void update(Area area) throws Exception;
  
    public void delete(Area area) throws Exception;
  
    public List<Area> find(Area area) throws Exception;
    
    public int count(Area area) throws Exception;
    
    public String max(Area area) throws Exception;
}  