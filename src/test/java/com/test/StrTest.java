package com.test;

import org.junit.Test;

import com.official.util.Const;

public class StrTest {

	@Test
	public void testName() throws Exception {
		String name = "实验组训练-11－说明.xls";

		if (!name.endsWith(Const.LATEST_EXCEL_SUBFFIX) && !name.endsWith(Const.OLD_EXCEL_SUBFFIX)) {
			System.out.println("fuck");
		}
	}
}
