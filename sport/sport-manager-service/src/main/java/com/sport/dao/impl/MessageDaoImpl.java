package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.MessageDao;
import com.sport.mapper.MessageMapper;
import com.sport.model.Message;

import org.springframework.stereotype.Repository;

 
@Repository
public class MessageDaoImpl implements MessageDao {
    @Autowired
    private MessageMapper messageMapper;
  
    /**
	 * 增加留言
	 * @param message
     * @throws Exception 
	 */
	public void addMessage(Message message) throws Exception{
		messageMapper.add(message);
	}
    /**
     * 根据主键查找留言
     * @param message
     * @return
     * @throws Exception 
     */
    public Message getMessageById(Message message) throws Exception{
    	return messageMapper.get(message);
    }
    /**
     * 更新留言
     * @param message
     * @throws Exception 
     */
    public void updateMessage(Message message) throws Exception{
    	messageMapper.update(message);
    }
    /**
     * 删除留言
     * @param message
     * @throws Exception 
     */
    public void deleteMessage(Message message) throws Exception{
    	messageMapper.delete(message);
    }
    /**
     * 查找留言
     * @param message
     * @return
     * @throws Exception 
     */
    public List<Message> findMessages(Message message) throws Exception{
    	return messageMapper.find(message);
    }
    /**
     * 统计留言记录数
     * @param message
     * @return
     * @throws Exception 
     */
    public int countMessages(Message message) throws Exception{
    	return messageMapper.count(message);
    }
}  
