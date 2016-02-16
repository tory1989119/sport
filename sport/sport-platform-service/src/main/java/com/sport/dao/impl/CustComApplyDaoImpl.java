package com.sport.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sport.dao.CustComApplyDao;
import com.sport.mapper.CustComApplyMapper;
import com.sport.model.CustComApply;


@Repository
public class CustComApplyDaoImpl implements CustComApplyDao {
	
	@Autowired
	private CustComApplyMapper custComApplyMapper;
	
	/**
	 * 根据主键查找对象
	 * @param pk
	 * @return
	 * @throws Exception
	 */
	public CustComApply findByPK(long pk) throws Exception {
		CustComApply custComApply = new CustComApply();
		custComApply.setId(pk);
		return custComApplyMapper.findByPK(custComApply);
	}
	/**
	 * 查找所有对象
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findAll() throws Exception {
		return custComApplyMapper.findAll();
	}
	/**
	 * 分页查找对象
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public List<CustComApply> findPage(CustComApply custComApply) throws Exception {
		return custComApplyMapper.findPage(custComApply);
	}
	/**
	 * 对象记录数
	 * @param custComApply
	 * @return
	 * @throws Exception
	 */
	public Integer count(CustComApply custComApply) throws Exception {
		return custComApplyMapper.count(custComApply);
	}
	/**
	 * 保存对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void save(CustComApply custComApply) throws Exception {
		custComApplyMapper.save(custComApply);
	}
	/**
	 * 更新对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void update(CustComApply custComApply) throws Exception {
		custComApplyMapper.update(custComApply);
	}
	/**
	 * 根据条件删除对象
	 * @param custComApply
	 * @throws Exception
	 */
	public void delete(CustComApply custComApply) throws Exception {
		custComApplyMapper.delete(custComApply);
	}
	/**
	 * 根据主键删除对象
	 * @param pk
	 * @throws Exception
	 */
	public void deleteByPK(long pk) throws Exception{
		CustComApply custComApply = new CustComApply();
		custComApply.setId(pk);
		custComApplyMapper.deleteByPK(custComApply);
	}
	
}
