package com.official.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.official.entity.Score;

public class ExcelUtil {

	public static void parseScoreToRow(XSSFRow row, Score score) {
		try {
			int j = 0;
			XSSFCell cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getName());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getCode());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getEngAge());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getAge());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getCet4());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getCet6());

			cell = row.createCell(j++);
			cell.setCellValue(score.getCustomer().getMajor());

			cell = row.createCell(j++);
			cell.setCellValue(score.getSubject().getSentence());

			cell = row.createCell(j++);
			cell.setCellValue(score.getReadTime1());

			cell = row.createCell(j++);
			cell.setCellValue(score.getReadTime2());

			cell = row.createCell(j++);
			cell.setCellValue(score.getReadTime3());

			cell = row.createCell(j++);
			cell.setCellValue(score.getReadTime4());

			cell = row.createCell(j++);
			cell.setCellValue(score.getReadTime5());

			cell = row.createCell(j++);
			cell.setCellValue(score.getMatch());
		} catch (Exception e) {

		}
	}
}
