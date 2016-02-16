package com.sport.service.impl;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sport.model.Picture;
import com.sport.service.PictureService;
import com.sport.service.interf.IPictureService;
import com.sport.util.FileUploadUtil;
import com.sport.common.util.GsonUtil;

@Service
@Scope("prototype")
public class PictureServiceImpl implements PictureService{
	@Autowired
	private IPictureService ipictureService;
	/**
	 * 获取图片
	 * @param request
	 * @param response
	 * @return
	 */
	public Picture getPictureById(HttpServletRequest request, HttpServletResponse response){
		Picture picture = null;
		try {
			picture = ipictureService.getPictureById(1);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return picture;
	}
	/**
	 * 添加或修改图片
	 * @param request
	 * @param response
	 * @return
	 */
	public String addOrEdit(HttpServletRequest request, HttpServletResponse response,String url){
			Picture picture = null;
			try {
				picture = ipictureService.getPictureById(1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}//默认为1
			if(picture == null){
				picture = new Picture();
				picture.setId(1);//默认为1
				picture.setUrl(url);
				picture.setAdate(new Timestamp(System.currentTimeMillis()));
				try {
					ipictureService.addPicture(picture);
				} catch (Exception e) {
					FileUploadUtil fu = new FileUploadUtil("上传失败",null);
		            return GsonUtil.getJsonFromObject(fu);
				}
			}else{
				picture.setId(1);//默认为1
				picture.setUrl(url);
				picture.setAdate(new Timestamp(System.currentTimeMillis()));
				try {
					ipictureService.updatePicture(picture);
				} catch (Exception e) {
					FileUploadUtil fu = new FileUploadUtil("上传失败",null);
		            return GsonUtil.getJsonFromObject(fu);
				}
			}
		
		FileUploadUtil fu = new FileUploadUtil(null,url);
        return GsonUtil.getJsonFromObject(fu);
	}
}
