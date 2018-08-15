package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import com.official.entity.Subject;

public class ExcelParseToSubjectTest {

	@Test
	public void testName() throws Exception {
		File file = new File("D:\\材料格式.xlsx");
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
				Subject subject = parseToSubject(row);

				// 执行数据库增加操作
				if (null != subject) {
					System.out.println(subject);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将excel的每一行的转换成对象
	 * 
	 * @param row
	 *            每一行excel
	 * @return Subject
	 */
	private Subject parseToSubject(Row row) {
		String sentence = getAsStr(row, 0);
		if (sentence == null || "".equals(sentence.trim())) {
			return null;
		}

		Subject sub = new Subject();
		try {
			sub.setSentence(sentence);
			sub.setKeyword(getAsStr(row, 1));
			sub.setType(getAsInt(row, 2));
			sub.setQuestion(getAsStr(row, 3));
			sub.setAnswer(getAsStr(row, 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sub;
	}

	private Integer getAsInt(Row row, int column) {
		Number value = (Number) getValue(row.getCell(column));
		return value.intValue();

	}

	private String getAsStr(Row row, int column) {
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
	private Object getValue(Cell cell) {
		if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			return cell.getNumericCellValue();
		}
		if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		}
		return cell.getStringCellValue();
	}
}
