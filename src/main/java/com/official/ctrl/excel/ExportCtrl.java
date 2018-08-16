package com.official.ctrl.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.official.entity.Score;
import com.official.service.score.ScoreService;
import com.official.util.ExcelUtil;
import com.official.util.FileUtil;

@Controller
@RequestMapping("/export/")
public class ExportCtrl {

	@Autowired
	private ScoreService scoreService;

	/**
	 * 下载结果
	 */
	@RequestMapping("/all")
	public void export(HttpServletResponse response) {

		List<Score> list = scoreService.compute();

		File file = buildResultExcel(list);
		FileUtil.download(response, file.getAbsolutePath());

		file.delete();
	}

	/**
	 * 创建结果excel
	 * 
	 * @return File
	 */
	private File buildResultExcel(List<Score> list) {
		String[] titles = {"姓名", "学号", "开始学习英语年龄", "年龄", "四级分数", "六级分数", "专业", "句子类型	原句（逐词呈现的句子）", "单词１阅读时间",
				"单词２阅读时间", "单词３阅读时间", "单词４阅读时间", "单词５阅读时间", "问题回答正确率"};

		File file = new File("统计结果.xlsx");

		try {

			// 创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("统计结果");
			XSSFRow row = sheet.createRow(0);

			for (int index = 0, len = titles.length; index < len; index++) {
				XSSFCell cell = row.createCell(index);
				cell.setCellValue(titles[index]);
			}

			if (null != list && list.size() > 0) {
				for (int index = 0, size = list.size(); index < size; index++) {
					row = sheet.createRow(index + 1);
					Score score = list.get(index);
					ExcelUtil.parseScoreToRow(row, score);
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
