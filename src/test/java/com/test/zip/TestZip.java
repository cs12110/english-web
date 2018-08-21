package com.test.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

import com.official.util.FileUtil;

public class TestZip {

	@Test
	public void testName() throws Exception {

		String path = "D:\\Pro\\project\\my-code\\english-web\\docs";
		File dir = new File(path);
		File[] files = dir.listFiles();

		/**
		 * 创建一个临时压缩文件， 我们会把文件流全部注入到这个文件中 这里的文件你可以自定义是.rar还是.zip
		 */
		File file = new File("d:\\my.zip");
		if (!file.exists()) {
			file.createNewFile();
		}

		// response.getWriter()
		// 创建文件输出流
		FileOutputStream fous = new FileOutputStream(file);
		/**
		 * 打包的方法我们会用到ZipOutputStream这样一个输出流, 所以这里我们把输出流转换一下
		 */
		ZipOutputStream zipOut = new ZipOutputStream(fous);
		/**
		 * 这个方法接受的就是一个所要打包文件的集合， 还有一个ZipOutputStream
		 */
		for (File e : files) {
			FileUtil.zipFile(e, zipOut);
		}
		zipOut.close();
		fous.close();
	}

}
