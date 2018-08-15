package com.test;

import org.junit.Test;

import com.official.util.Md5Util;

public class Md5Test {

	@Test
	public void testName() throws Exception {
		System.out.println(Md5Util.encode("123456"));
	}

}
