package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.official.App;
import com.official.service.sys.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
@WebAppConfiguration
public class SysUserSeviceTest {

	@Autowired
	private SysUserService sysUserService;

	@Test
	public void testSelect() {
		System.out.println(sysUserService.findByUserName("3306"));
	}

}
