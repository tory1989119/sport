package com.sport.mapper;

import com.sport.model.Picture;

public interface PictureMapper {  
  
	public void add(Picture picture) throws Exception;
  
	public Picture get(Picture picture) throws Exception;
  
	public void update(Picture picture) throws Exception;
  
	public void delete(Picture picture) throws Exception;
}  