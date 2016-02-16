package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.MessageDao;
import com.sport.model.Message;
import com.sport.service.interf.IMessageService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("messageService")
@Transactional(readOnly = true)
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageDao messageDao;
	/**
	 * 增加留言
	 * @param message
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addMessage(Message message) throws Exception {
    	messageDao.addMessage(message);
    }  
    /**
     * 根据主键查找留言
     * @param id
     * @return
     * @throws Exception 
     */ 
    public Message getMessageById(long id) throws Exception {
    	Message message = new Message();
    	message.setId(id);
        return messageDao.getMessageById(message);
    }  
    /**
     * 更新留言
     * @param message
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateMessage(Message message) throws Exception {
    	messageDao.updateMessage(message);
    }  
    /**
     * 删除留言
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteMessage(long id) throws Exception {
    	Message message = new Message();
    	message.setId(id);
    	messageDao.deleteMessage(message);
    }  
    /**
     * 查询留言
     * @param message
     * @return
     * @throws Exception 
     */
    public List<Message> findMessages(Message message) throws Exception{
    	return messageDao.findMessages(message);
    }
    /**
     * 统计留言记录数
     * @param message
     * @return
     * @throws Exception 
     */
    public int countMessages(Message message) throws Exception{
    	return messageDao.countMessages(message);
    }
}  
