package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.ActJoinInfoDao;
import com.sport.model.ActJoinInfo;
import com.sport.service.interf.IActJoinInfoService;

@Service("actJoinInfoService")
@Transactional(readOnly = true)
public class ActJoinInfoServiceImpl implements IActJoinInfoService {
	
	@Autowired
	private ActJoinInfoDao actJoinInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActJoinInfo findByPK(long pk) throws Exception {
		return actJoinInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findAll() throws Exception {
		return actJoinInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActJoinInfo> findPage(ActJoinInfo actJoinInfo) throws Exception {
		return actJoinInfoDao.findPage(actJoinInfo);
	}
	/**
	 * 对象记录数
	 * @param actJoinInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActJoinInfo actJoinInfo) throws Exception {
		return actJoinInfoDao.count(actJoinInfo);
	}
	/**
	 * 保存对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoDao.save(actJoinInfo);
	}
	/**
	 * 更新对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoDao.update(actJoinInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actJoinInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(ActJoinInfo actJoinInfo) throws Exception {
		actJoinInfoDao.delete(actJoinInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		actJoinInfoDao.deleteByPK(pk);
	}
	
}
