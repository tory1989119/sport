package com.sport.mapper;

import java.util.List;

import com.sport.model.Message;

public interface MessageMapper {  
  
    public void add(Message message) throws Exception;
  
    public Message get(Message message) throws Exception;
  
    public void update(Message message) throws Exception;
  
    public void delete(Message message) throws Exception;
  
    public List<Message> find(Message message) throws Exception;
    
    public int count(Message message) throws Exception;
}  