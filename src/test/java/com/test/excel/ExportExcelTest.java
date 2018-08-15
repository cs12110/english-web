package com.test.excel;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExportExcelTest {

	@Test
	public void testName() throws Exception {
		buildResultExcel();
	}

	/**
	 * 创建结果excel
	 * 
	 * @return File
	 */
	private File buildResultExcel() {
		String[] titles = {"姓名", "学号", "开始学习英语年龄", "年龄", "四级分数", "六级分数", "专业", "句子类型	原句（逐词呈现的句子）", "单词１阅读时间",
				"单词２阅读时间", "单词３阅读时间", "单词４阅读时间", "单词５阅读时间", "问题回答正确率"};

		System.out.println(titles.length);
		try {

			// 创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			// 新建工作表
			XSSFSheet sheet = workbook.createSheet("统计结果");
			// 创建行,0表示第一行
			XSSFRow row = sheet.createRow(0);
			// 创建单元格行号由row确定,列号作为参数传递给createCell;第一列从0开始计算
			for (int index = 0, len = titles.length; index < len; index++) {
				XSSFCell cell = row.createCell(index);
				cell.setCellValue(titles[index]);
			}

			for (int rowIndex = 1; rowIndex < 10; rowIndex++) {
				row = sheet.createRow(rowIndex);
				for (int index = 0, len = titles.length; index < len; index++) {
					XSSFCell cell = row.createCell(index);
					cell.setCellValue(index);
					System.out.println(index);
				}
			}
			// 给单元格赋值
			// 创建输出流
			FileOutputStream fos = new FileOutputStream(new File("d://test.xlsx"));
			workbook.write(fos);

			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
