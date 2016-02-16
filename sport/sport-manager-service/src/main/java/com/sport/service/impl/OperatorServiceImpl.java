package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.OperatorDao;
import com.sport.model.Operator;
import com.sport.service.interf.IOperatorService;

import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

 
@Service("operatorService")
@Transactional(readOnly = true)
public class OperatorServiceImpl implements IOperatorService {
    @Autowired
    private OperatorDao operatorDao;
	/**
	 * 增加操作员
	 * @param operator
	 * @throws Exception 
	 */
    @Transactional(readOnly = false)
    public void addOperator(Operator operator) throws Exception {
    	operatorDao.addOperator(operator);
    }  
    /**
     * 根据主键查找操作员
     * @param id
     * @return
     * @throws Exception 
     */
    public Operator getOperatorById(long id) throws Exception {
    	Operator operator = new Operator();
    	operator.setId(id);
        return operatorDao.getOperatorById(operator);
    }  
    /**
     * 更新操作员
     * @param operator
     * @throws Exception 
     */
    @Transactional(readOnly = false)  
    public void updateOperator(Operator operator) throws Exception {
    	operatorDao.updateOperator(operator);
    }  
    /**
     * 删除操作员
     * @param id
     * @throws Exception 
     */
    @Transactional(readOnly = false) 
    public void deleteOperator(long id) throws Exception {
    	Operator operator = new Operator();
    	operator.setId(id);
    	operatorDao.deleteOperator(operator);
    }  
    /**
     * 查询操作员
     * @param operator
     * @return
     * @throws Exception 
     */
    public List<Operator> findOperators(Operator operator) throws Exception{
    	return operatorDao.findOperators(operator);
    }
    /**
     * 统计操作员记录数
     * @param operator
     * @return
     * @throws Exception 
     */
	@Override
	public int countOperators(Operator operator) throws Exception {
		return operatorDao.countOperators(operator);
	}
    /**
     * 登录
     * @param operator
     * @return
     * @throws Exception 
     */
	@Override
	public Operator login(Operator operator) throws Exception {
		return operatorDao.login(operator);
	}
}  
