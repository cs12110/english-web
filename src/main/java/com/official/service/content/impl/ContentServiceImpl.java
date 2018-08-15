package com.official.service.content.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.entity.ContentEntity;
import com.official.mapper.ContentMapper;
import com.official.service.content.ContentService;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private ContentMapper contentMapper;

	@Override
	public List<ContentEntity> selectContent(ContentEntity search) {

		if (null == search) {
			return Collections.emptyList();
		}

		return contentMapper.selectContent(search);
	}

}
