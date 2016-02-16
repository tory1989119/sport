package com.sport.mapper;

import java.util.List;

import com.sport.model.Data;

public interface DataMapper {  
  
    public void add(Data data) throws Exception;
  
    public Data get(Data data) throws Exception;
  
    public void update(Data data) throws Exception;
  
    public void delete(Data data) throws Exception;
  
    public List<Data> find(Data data) throws Exception;
}  