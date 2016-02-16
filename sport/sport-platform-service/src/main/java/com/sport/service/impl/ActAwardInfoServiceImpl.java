package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.ActAwardInfoDao;
import com.sport.model.ActAwardInfo;
import com.sport.service.interf.IActAwardInfoService;

@Service("actAwardInfoService")
@Transactional(readOnly = true)
public class ActAwardInfoServiceImpl implements IActAwardInfoService {
	
	@Autowired
	private ActAwardInfoDao actAwardInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public ActAwardInfo findByPK(long pk) throws Exception {
		return actAwardInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findAll() throws Exception {
		return actAwardInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public List<ActAwardInfo> findPage(ActAwardInfo actAwardInfo) throws Exception {
		return actAwardInfoDao.findPage(actAwardInfo);
	}
	/**
	 * 对象记录数
	 * @param actAwardInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(ActAwardInfo actAwardInfo) throws Exception {
		return actAwardInfoDao.count(actAwardInfo);
	}
	/**
	 * 保存对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoDao.save(actAwardInfo);
	}
	/**
	 * 更新对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoDao.update(actAwardInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param actAwardInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(ActAwardInfo actAwardInfo) throws Exception {
		actAwardInfoDao.delete(actAwardInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		actAwardInfoDao.deleteByPK(pk);
	}
}
