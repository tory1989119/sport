package com.sport.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sport.model.Data;
import com.sport.redis.RedisObjectDAO;
import com.sport.redis.model.StoreObject;
import com.sport.service.interf.IDataService;
  
public class InitServlet extends HttpServlet {  
	private static Logger logger = Logger.getLogger(InitServlet.class);
      
    private static final long serialVersionUID = -7718302829857998640L;
    private static String contextPath;
    private static String classPath;
              
    @Override  
    public void init(ServletConfig config) throws ServletException {  
        super.init(config);
          
        String prefix = config.getServletContext().getRealPath("/");
        InitServlet.contextPath = prefix;
        InitServlet.classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        
        ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        RedisObjectDAO redisObjectDAO = (RedisObjectDAO) context.getBean("redisObjectDAOImpl");
        
        logger.info("加载数据开始");
        initData(redisObjectDAO,context);//加载系统参数
        logger.info("加载数据结束");          
        
    }
    
    /**
     * 加载系统参数
     * @param redisObjectDAO
     * @param context
     */
    private void initData(RedisObjectDAO redisObjectDAO,WebApplicationContext context){
    	IDataService iDataService = (IDataService) context.getBean("idataService");
    	Data fdata = new Data();
    	fdata.setGrade("0");
    	List<Data> fdatal = new ArrayList<Data>();
		try {
			fdatal = iDataService.findDatas(fdata);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	for (int i = 0; i < fdatal.size(); i++) {
    		//将参数list放入redis
    		fdata = fdatal.get(i);
    		Data zdata = new Data();
    		zdata.setGrade("1");
    		zdata.setFid(fdata.getDataid());
    		List<Data> zdatal = new ArrayList<Data>();
			try {
				zdatal = iDataService.findDatas(zdata);
			} catch (Exception e) {
				e.printStackTrace();
			}
    		
    		StoreObject sol = new StoreObject();
    		sol.setId(fdata.getDataid());
    		sol.setObject(zdatal);
    		redisObjectDAO.set(sol);
    		
    		//将参数装成map放入redis
    		Map<String, String> zdatam = new HashMap<String, String>();
    		for (int j = 0; j < zdatal.size(); j++) {
    			zdata = zdatal.get(j);
    			zdatam.put(zdata.getDataid(), zdata.getDataname());
			}
    		
    		StoreObject som = new StoreObject();
    		som.setId(fdata.getDataid() + "M");
    		som.setObject(zdatam);
    		redisObjectDAO.set(som);
		}
    }
      
      
    @Override  
    public void destroy() {  
    }  
      
    public static final String getContextPath() {  
        return InitServlet.contextPath;
    }  
      
    public static final String getClassPath() {  
        return classPath;
    }  
      
}
