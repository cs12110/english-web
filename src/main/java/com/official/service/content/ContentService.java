package com.official.service.content;

import java.util.List;

import com.official.entity.ContentEntity;

public interface ContentService {

	/**
	 * 查找符合条件的内容
	 * 
	 * @param search
	 *            查询参数
	 * @return List
	 */
	public List<ContentEntity> selectContent(ContentEntity search);

}
