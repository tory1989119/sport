package com.sport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sport.dao.CustComApplyDao;
import com.sport.dao.CustComInfoDao;
import com.sport.exception.BusException;
import com.sport.model.CustComApply;
import com.sport.model.CustComInfo;
import com.sport.service.interf.ICustComApplyService;


@Service("custComApplyService")
@Transactional(readOnly = true)
public class CustComApplyServiceImpl implements ICustComApplyService {
	@Autowired
	private CustComApplyDao custComApplyDao;
	@Autowired
	private CustComInfoDao custComInfoDao;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComApply findByPK(long pk) throws Exception {
		return custComApplyDao.findByPK(pk);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findAll() throws Exception {
		return custComApplyDao.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findPage(CustComApply custComApply) throws Exception {
		return custComApplyDao.findPage(custComApply);
	}
	/**
	 * 对象记录数
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComApply custComApply) throws Exception {
		return custComApplyDao.count(custComApply);
	}
	/**
	 * 保存对象
	 * @param custComApply
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void save(CustComApply custComApply) throws Exception {
		custComApplyDao.save(custComApply);
	}
	/**
	 * 更新对象
	 * @param custComApply
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void update(CustComApply custComApply) throws Exception {
		custComApplyDao.update(custComApply);
	}
	/**
	 * 根据条件删除对象
	 * @param custComApply
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void delete(CustComApply custComApply) throws Exception {
		custComApplyDao.delete(custComApply);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false)
	public void deleteByPK(long pk) throws Exception{
		custComApplyDao.deleteByPK(pk);
	}
	
	/**
	 * 审核主办方
	 * @param pk
	 * @throws Exception
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void check(CustComApply custComApply) throws Exception{
		try {
			CustComApply cca= custComApplyDao.findByPK(custComApply.getId());
			cca.setApplyStatus(custComApply.getApplyStatus());
			cca.setNote(custComApply.getNote());
			custComApplyDao.update(cca);
			//审核通过修改用户信息
			if(custComApply.getApplyStatus().equals("1")){
				CustComInfo custComInfo = custComInfoDao.findByPK(cca.getComId());
				custComInfo.setComLogo(cca.getComLogo());
				custComInfo.setComLicensePic(cca.getComLicensePic());
				custComInfo.setComAuthorizePic(cca.getComAuthorizePic());
				custComInfoDao.update(custComInfo);
			}
		} catch (Exception e) {
			throw new BusException("修改审核信息出错!");
		}
	}
	
}
