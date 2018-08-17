package com.official.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.official.entity.Customer;
import com.official.entity.Score;
import com.official.entity.Subject;

/**
 * Excel工具类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public class ExcelUtil {
	/**
	 * 获取值
	 * 
	 * @param row
	 *            行
	 * @param column
	 *            列
	 * @return Integer
	 */
	public static Integer getAsInt(Row row, int column) {
		Number value = (Number) getValue(row.getCell(column));
		return value.intValue();
	}

	/**
	 * 获取值
	 * 
	 * @param row
	 *            行
	 * @param column
	 *            列
	 * @return String
	 */
	public static String getAsStr(Row row, int column) {
		Object value = getValue(row.getCell(column));
		return String.valueOf(value);
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 *            单元格
	 * @return String
	 */
	private static Object getValue(Cell cell) {
		if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue();
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getRichStringCellValue().getString();
		}
		return cell.getStringCellValue();
	}

	/**
	 * 创建结果excel
	 * 
	 * @return File
	 */
	public static File buildScoreResultExcel(List<Score> list) {
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

	/**
	 * 将成绩对象转换成excel的行数据
	 * 
	 * @param row
	 *            行
	 * @param score
	 *            成绩对象
	 */
	private static void parseScoreToRow(XSSFRow row, Score score) {
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

	/**
	 * 获取值
	 * 
	 * @param obj
	 *            对象
	 * @return String
	 */
	private static String asStr(Object obj) {
		if (null == obj) {
			return "";
		}
		return String.valueOf(obj);
	}

	/**
	 * 将excel的每一行的转换成对象
	 * 
	 * @param row
	 *            每一行excel
	 * @return Subject
	 */
	public static Subject parseToSubject(Row row) {
		String sentence = ExcelUtil.getAsStr(row, 0);
		if (sentence == null || "".equals(sentence.trim())) {
			return null;
		}

		Subject sub = new Subject();
		try {
			sub.setSentence(sentence);
			sub.setKeyword(ExcelUtil.getAsStr(row, 1));
			sub.setType(ExcelUtil.getAsInt(row, 2));
			sub.setQuestion(ExcelUtil.getAsStr(row, 3));
			sub.setAnswer(ExcelUtil.getAsStr(row, 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sub;
	}
}
