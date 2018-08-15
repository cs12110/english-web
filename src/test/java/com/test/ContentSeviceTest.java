package com.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.official.App;
import com.official.entity.ContentEntity;
import com.official.service.content.ContentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class ContentSeviceTest {

	@Autowired
	private ContentService contentService;

	@Test
	public void testSelect() {

		ContentEntity search = new ContentEntity();

		search.setName("海燕");

		List<ContentEntity> selectContent = contentService
				.selectContent(search);

		System.out.println(selectContent);
	}

}
