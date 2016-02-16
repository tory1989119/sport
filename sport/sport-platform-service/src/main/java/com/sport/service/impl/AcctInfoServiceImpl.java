package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.AcctInfoDao;
import com.sport.dao.CustComInfoDao;
import com.sport.dao.CustPersonInfoDao;
import com.sport.model.AcctInfo;
import com.sport.model.CustComInfo;
import com.sport.model.CustPersonInfo;
import com.sport.service.interf.IAcctInfoService;


@Service("acctInfoService")
@Transactional(readOnly = true)
public class AcctInfoServiceImpl implements IAcctInfoService {
	
	@Autowired
	private AcctInfoDao acctInfoDao;
	@Autowired
	private CustComInfoDao custComInfoDao;
	@Autowired
	private CustPersonInfoDao custPersonInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public AcctInfo findByPK(long pk) throws Exception {
		return acctInfoDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findAll() throws Exception {
		return acctInfoDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public List<AcctInfo> findPage(AcctInfo acctInfo) throws Exception {
		return acctInfoDao.findPage(acctInfo);
	}
	/**
	 * 对象记录数
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public Integer count(AcctInfo acctInfo) throws Exception {
		return acctInfoDao.count(acctInfo);
	}
	/**
	 * 保存对象
	 * @param acctInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void regist(AcctInfo acctInfo) throws Exception {
		acctInfoDao.save(acctInfo);
		AcctInfo ai = acctInfoDao.login(acctInfo);
		if(ai.getAcctType().equals("0")){
			CustComInfo custComInfo = new CustComInfo();
			custComInfo.setAcctId(ai.getId());
			custComInfo.setComName(ai.getUsername());
			custComInfoDao.save(custComInfo);
		}else{
			CustPersonInfo custPersonInfo = new CustPersonInfo();
			custPersonInfo.setAcctId(ai.getId());
			custPersonInfo.setRealName(ai.getUsername());
			custPersonInfoDao.save(custPersonInfo);
		}
	}
	/**
	 * 更新对象
	 * @param acctInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(AcctInfo acctInfo) throws Exception {
		acctInfoDao.update(acctInfo);
	}
	/**
	 * 根据条件删除对象
	 * @param acctInfo
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(AcctInfo acctInfo) throws Exception {
		acctInfoDao.delete(acctInfo);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		acctInfoDao.deleteByPK(pk);
	}
	
	/**
	 * 登录
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public AcctInfo login(AcctInfo acctInfo) throws Exception {
		return acctInfoDao.login(acctInfo);
	}
	
	/**
	 * 校验登录名
	 * @param acctInfo
	 * @return
	 * @throws Exception
	 */
	public Integer checkUsername(AcctInfo acctInfo) throws Exception {
		return acctInfoDao.checkUsername(acctInfo);
	}
}
