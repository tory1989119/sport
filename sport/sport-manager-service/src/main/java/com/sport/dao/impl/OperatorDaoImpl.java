package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sport.dao.OperatorDao;
import com.sport.mapper.OperatorMapper;
import com.sport.model.Operator;

import org.springframework.stereotype.Repository;
 
@Repository
public class OperatorDaoImpl implements OperatorDao {
    @Autowired
    private OperatorMapper operatorMapper;
  
    /**
	 * 增加操作员
	 * @param operator
     * @throws Exception 
	 */
	public void addOperator(Operator operator) throws Exception{
		operatorMapper.add(operator);
	}
    /**
     * 根据主键查找操作员
     * @param operator
     * @return
     * @throws Exception 
     */
    public Operator getOperatorById(Operator operator) throws Exception{
    	return operatorMapper.get(operator);
    }
    /**
     * 更新操作员
     * @param operator
     * @throws Exception 
     */
    public void updateOperator(Operator operator) throws Exception{
    	operatorMapper.update(operator);
    }
    /**
     * 删除操作员
     * @param operator
     * @throws Exception 
     */
    public void deleteOperator(Operator operator) throws Exception{
    	operatorMapper.delete(operator);
    }
    /**
     * 查找操作员
     * @param operator
     * @return
     * @throws Exception 
     */
    public List<Operator> findOperators(Operator operator) throws Exception{
    	return operatorMapper.find(operator);
    }
    /**
     * 统计操作员记录数
     * @param operator
     * @return
     * @throws Exception 
     */
    public int countOperators(Operator operator) throws Exception{
    	return operatorMapper.count(operator);
    }
    /**
     * 登录
     * @param operator
     * @return
     * @throws Exception 
     */
    public Operator login(Operator operator) throws Exception{
    	return operatorMapper.login(operator);
    }
}  
