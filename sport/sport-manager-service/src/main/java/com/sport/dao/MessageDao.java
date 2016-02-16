package com.sport.dao;

import java.util.List;

import com.sport.model.Message;
 
public interface MessageDao {
	/**
	 * 增加留言
	 * @param message
	 * @throws Exception 
	 */
	public void addMessage(Message message) throws Exception;
    /**
     * 根据主键查找留言
     * @param message
     * @return
     * @throws Exception 
     */
    public Message getMessageById(Message message) throws Exception;
    /**
     * 更新留言
     * @param message
     * @throws Exception 
     */
    public void updateMessage(Message message) throws Exception;
    /**
     * 删除留言
     * @param message
     * @throws Exception 
     */
    public void deleteMessage(Message message) throws Exception;
    /**
     * 查找留言
     * @param message
     * @return
     * @throws Exception 
     */
    public List<Message> findMessages(Message message) throws Exception;
    /**
     * 统计留言记录数
     * @param message
     * @return
     * @throws Exception 
     */
    public int countMessages(Message message) throws Exception;
}
