package com.sport.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Message;
import com.sport.model.SessionInfo;
import com.sport.redis.RedisObjectDAO;
import com.sport.service.MessageService;
import com.sport.service.interf.IMessageService;
import com.sport.common.util.AjaxReturnUtil;
import com.sport.common.util.GsonUtil;
import com.sport.common.util.PageUtil;

@Service
@Scope("prototype")
public class MessageServiceImpl implements MessageService{
	@Autowired
	private IMessageService imessageService;
	@Autowired
	private RedisObjectDAO redisObjectDAO;
	/**
	 * 查询留言列表
	 * @param request
	 * @param response
	 * @return
	 */
	public String getList(HttpServletRequest request, HttpServletResponse response){
	    String draw = "0";//获取请求次数
	    draw = request.getParameter("draw");
	    String start = request.getParameter("start");//数据起始位置
	    String length = request.getParameter("length");//数据长度
	    
	    
	    String startdate = request.getParameter("startdate");
	    String enddate = request.getParameter("enddate");
	    String actId = request.getParameter("actId");
	    String personId = request.getParameter("personId");
	    String customerId = request.getParameter("customerId");
		
		Message message = new Message();
		message.setStartdate(startdate);
		message.setEnddate(enddate);
		if(actId != "" && actId != null){
			message.setActId(Long.parseLong(actId));
		}
		
		if(personId != "" && personId != null){
			message.setPersonId(Long.parseLong(personId));
		}
		
		if(customerId != "" && customerId != null){
			message.setCustomerId(Long.parseLong(customerId));
		}
		
		message.setStart(Integer.valueOf(start));
		message.setLength(Integer.valueOf(length));
		
		List<Message> data = new ArrayList<Message>();
		int count = 0;
		try {
			data = imessageService.findMessages(message);
			count = imessageService.countMessages(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageUtil page = new PageUtil(Integer.valueOf(draw), count, count, data);
		return GsonUtil.getJsonFromObject(page);
	}
	/**
	 * 修改留言
	 * @param request
	 * @param response
	 * @return
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response, SessionInfo si){
		String reply = request.getParameter("reply");
		Message message = new Message();
		message.setId(Long.parseLong(request.getParameter("id")));
		message.setReply(reply);
		message.setRdate(new Timestamp(System.currentTimeMillis()));
		
		//message.setCustomerId(si.getId());
		//message.setCustomer_name(si.getName());
		try {
			imessageService.updateMessage(message);
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
	/**
	 * 删除留言
	 * @param request
	 * @param response
	 * @return
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response){
		try {
			imessageService.deleteMessage(Long.parseLong(request.getParameter("id")));
		} catch (Exception e) {
			AjaxReturnUtil rmsg = new AjaxReturnUtil(false,e.getMessage(),null);
			return GsonUtil.getJsonFromObject(rmsg);
		}
		AjaxReturnUtil rmsg = new AjaxReturnUtil(true,"成功",null);
		return GsonUtil.getJsonFromObject(rmsg);
	}
}
