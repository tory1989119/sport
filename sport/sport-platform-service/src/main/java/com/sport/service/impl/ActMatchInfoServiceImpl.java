package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.ActMatchInfoDao;
import com.sport.model.ActMatchInfo;
import com.sport.service.interf.IActMatchInfoService;

@Service("actMatchInfoService")
@Transactional(readOnly = true)
public class ActMatchInfoServiceImpl implements IActMatchInfoService {
	
	@Autowired
	private ActMatchInfoDao actMatchInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActMatchInfo findByPK(long pk) throws Exception {
		return actMatchInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findAll() throws Exception {
		return actMatchInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActMatchInfo> findPage(ActMatchInfo actMatchInfo) throws Exception {
		return actMatchInfoDao.findPage(actMatchInfo);
	}
	/**
	 * 对象记录数
	 * @param actMatchInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActMatchInfo actMatchInfo) throws Exception {
		return actMatchInfoDao.count(actMatchInfo);
	}
	/**
	 * 保存对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoDao.save(actMatchInfo);
	}
	/**
	 * 更新对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoDao.update(actMatchInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actMatchInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(ActMatchInfo actMatchInfo) throws Exception {
		actMatchInfoDao.delete(actMatchInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		actMatchInfoDao.deleteByPK(pk);
	}
	
}
