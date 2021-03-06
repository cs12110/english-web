package com.test.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.official.entity.Subject;
import com.official.util.ExcelUtil;

public class AfterExcelTest {

	@Test
	public void testBefore() throws Exception {
		File file = new File("d:\\实验组训练-11－说明.xls");
		InputStream stream = new FileInputStream(file);

		processExcel(stream);
	}

	private void processExcel(InputStream stream) {
		try {
			Workbook workBook = WorkbookFactory.create(stream);

			Sheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);

				String sentence = ExcelUtil.getAsStr(row, 0);
				if (null == sentence || "".equals(sentence.trim())) {
					continue;
				}

				System.out.println(rowIndex);
				Subject subject = ExcelUtil.parseToLearningSubject(row, sentence);

				// 执行数据库增加操作
				if (null != subject) {
					System.out.println(subject);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
