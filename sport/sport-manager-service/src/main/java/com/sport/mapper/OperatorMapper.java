package com.sport.mapper;

import java.util.List;

import com.sport.model.Operator;


public interface OperatorMapper {  
  
	public void add(Operator operator) throws Exception;
  
	public Operator get(Operator operator) throws Exception;
  
	public void update(Operator operator) throws Exception;
  
	public void delete(Operator operator) throws Exception;
  
	public List<Operator> find(Operator operator) throws Exception;
    
	public int count(Operator operator) throws Exception;
	
	public Operator login(Operator operator) throws Exception;
}  