package com.official.ctrl.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.official.util.FileUtil;

@Controller
@RequestMapping("/export/")
public class ExportCtrl {

	/**
	 * 下载结果
	 */
	@RequestMapping("/all")
	public void export(HttpServletResponse response) {
		File file = buildResultExcel(null);
		FileUtil.download(response, file.getAbsolutePath());

		file.delete();
	}

	/**
	 * 创建结果excel
	 * 
	 * @return File
	 */
	private File buildResultExcel(List<Map<String, String>> list) {

		String[] titles = {"姓名", "学号", "开始学习英语年龄", "年龄", "四级分数", "六级分数", "专业", "句子类型	原句（逐词呈现的句子）", "单词１阅读时间",
				"单词２阅读时间", "单词３阅读时间", "单词４阅读时间", "单词５阅读时间", "问题回答正确率"};

		File file = new File("统计结果.xlsx");

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

			if (null != list && list.size() > 0) {
				for (int index = 0, size = list.size(); index < size; index++) {
					row = sheet.createRow(index + 1);
					Map<String, String> map = list.get(index);
					for (int j = 0, len = titles.length; j < len; j++) {
						XSSFCell cell = row.createCell(j);
						cell.setCellValue(map.get(titles[j]));
					}
				}
			}
			// 创建输出流
			FileOutputStream fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
}
