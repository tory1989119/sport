package com.sport.service.interf;

import java.util.List;

import com.sport.model.Operator;

 
public interface IOperatorService {
	/**
	 * 增加操作员
	 * @param operator
	 * @throws Exception 
	 */
	public void addOperator(Operator operator) throws Exception;
    /**
     * 根据主键查找操作员
     * @param id
     * @return
     * @throws Exception 
     */
    public Operator getOperatorById(long id) throws Exception;
    /**
     * 更新操作员
     * @param operator
     * @throws Exception 
     */
    public void updateOperator(Operator operator) throws Exception;
    /**
     * 删除操作员
     * @param id
     * @throws Exception 
     */
    public void deleteOperator(long id) throws Exception;
    /**
     * 查询操作员
     * @param operator
     * @return
     * @throws Exception 
     */
    public List<Operator> findOperators(Operator operator) throws Exception;
    /**
     * 统计操作员记录数
     * @param operator
     * @return
     * @throws Exception 
     */
    public int countOperators(Operator operator) throws Exception;
    /**
     * 登录
     * @param operator
     * @return
     * @throws Exception 
     */
    public Operator login(Operator operator) throws Exception;
}
