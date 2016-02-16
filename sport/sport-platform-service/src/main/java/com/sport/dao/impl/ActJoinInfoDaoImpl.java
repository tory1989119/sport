package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.ActJoinInfoDao;
import com.sport.mapper.ActJoinInfoMapper;
import com.sport.model.ActJoinInfo;

@Repository
public class ActJoinInfoDaoImpl implements ActJoinInfoDao {
	
	@Autowired
	private ActJoinInfoMapper actJoinInfoMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActJoinInfo findByPK(long pk) throws Exception {
		return actJoinInfoMapper.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findAll() throws Exception {
		return actJoinInfoMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findPage(ActJoinInfo actJoinInfo) throws Exception {
		return actJoinInfoMapper.findPage(actJoinInfo);
	}
	/**
	 * 对象记录数
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActJoinInfo actJoinInfo) throws Exception {
		return actJoinInfoMapper.count(actJoinInfo);
	}
	/**
	 * 保存对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	public void save(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoMapper.save(actJoinInfo);
	}
	/**
	 * 更新对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	public void update(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoMapper.update(actJoinInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	public void delete(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoMapper.delete(actJoinInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		actJoinInfoMapper.deleteByPK(pk);
	}
	
}
