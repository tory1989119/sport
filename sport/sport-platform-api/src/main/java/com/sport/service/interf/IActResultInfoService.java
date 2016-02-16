package com.sport.service.interf;

import java.util.List;

import com.sport.model.ActResultInfo;

public interface IActResultInfoService{
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActResultInfo findByPK(long pk) throws Exception;
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findAll() throws Exception;
	/**
	 * 分页查找对象
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActResultInfo> findPage(ActResultInfo actResultInfo) throws Exception;
	/**
	 * 对象记录数
	 * @param actResultInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActResultInfo actResultInfo) throws Exception;
	/**
	 * 保存对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void save(ActResultInfo actResultInfo) throws Exception;
	/**
	 * 更新对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void update(ActResultInfo actResultInfo) throws Exception;
	/**
	 * 根据条件删除对象
	 * @param actResultInfo
	 * @throws Exception
	 */
	public void delete(ActResultInfo actResultInfo) throws Exception;
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception;
}
