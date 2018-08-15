package com.official.mapper;

import java.util.List;

import com.official.entity.ContentEntity;

import tk.mybatis.mapper.common.Mapper;

public interface ContentMapper extends Mapper<ContentEntity> {

	/**
	 * 查询
	 * 
	 * @param search
	 *            查询参数
	 * @return List
	 */
	List<ContentEntity> selectContent(ContentEntity search);

}