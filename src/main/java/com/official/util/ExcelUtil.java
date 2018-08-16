package com.official.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import com.official.entity.Customer;
import com.official.entity.Score;
import com.official.entity.Subject;

public class ExcelUtil {

	public static void parseScoreToRow(XSSFRow row, Score score) {
		try {

			Customer customer = score.getCustomer();
			int j = 0;
			XSSFCell cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getName()));

			cell = row.createCell(j++);
			cell.setCellValue(customer.getCode());

			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getEngAge()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getAge()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getCet4()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getCet6()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getMajor()));

			Subject subject = score.getSubject();
			cell = row.createCell(j++);
			cell.setCellValue(asStr(subject.getSentence()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getReadTime1()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getReadTime2()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getReadTime3()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getReadTime4()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getReadTime5()));

			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getCorrect()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String asStr(Object obj) {
		if (null == obj) {
			return "";
		}
		return String.valueOf(obj);
	}
}
