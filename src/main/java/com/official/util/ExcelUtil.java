package com.official.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.official.entity.Customer;
import com.official.entity.Score;
import com.official.entity.Subject;
import com.official.enums.PaperEnum;

/**
 * Excel工具类
 *
 * @author huanghuapeng 2018年8月17日
 * @see
 * @since 1.0
 */
public class ExcelUtil {

	private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	/**
	 * 处理excel文件数据进数据库
	 * 
	 * @param dataSource 数据源
	 * @param stream     文件流
	 * @param paperEnum  上传测试类型
	 * @return Map {success:成功处理条数,failure:失败处理条数}
	 */
	public static Map<String, Integer> saveSubjectExcelIntoDb(DataSource dataSource, InputStream stream,
			PaperEnum paperEnum) {
		Map<String, Integer> map = new HashMap<String, Integer>(1);
		try {
			JdbcBatchUtil batchUtil = new JdbcBatchUtil(dataSource);
			Workbook workBook = WorkbookFactory.create(stream);
			Sheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			int success = 0;
			int failure = 0;
			int batch = 50;

			List<Subject> list = new ArrayList<Subject>();
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);

				String sentence = ExcelUtil.getAsStr(row, 0);
				if (null == sentence || "".equals(sentence.trim())) {
					logger.info("Parse {} row sentence is null", rowIndex);
					continue;
				}
				Subject subject = parseToSubject(row, paperEnum.getValue());
				if (null != subject) {
					subject.setPaper(paperEnum.getValue());
					list.add(subject);
				} else {
					logger.info("Parse {} row to {} subject  didn't work out", rowIndex, paperEnum);
				}
				if (list.size() > 0 && list.size() % batch == 0) {
					try {
						batchUtil.process(list);
						list.clear();
						success += batch;
					} catch (Exception e) {
						logger.error("Jdbc batch error:{}", e.getMessage());
						failure += batch;
					}
				}
			}
			if (list.size() > 0) {
				success += list.size();
				batchUtil.process(list);
			}
			map.put("success", success);
			map.put("failure", failure);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return map;
	}

	/**
	 * 将excel的每一行的转换成对象
	 * 
	 * @param row   每一行excel
	 * @param paper 测试类型
	 * @return Subject
	 */
	private static Subject parseToSubject(Row row, Integer paper) {
		String sentence = ExcelUtil.getAsStr(row, 0);
		/**
		 * 前测,后测,追踪一模一样
		 */
		if ((paper == PaperEnum.BEFORE.getValue()) || (paper == PaperEnum.AFTER.getValue())
				|| (paper == PaperEnum.TRACE.getValue())) {

			if (row.getPhysicalNumberOfCells() == Const.SUB1_LENGTH) {
				return parseToBeforeSubject(row, sentence);
			}

		}

		/**
		 * 其他学习的两次一模一样的格式
		 */
		if (paper == PaperEnum.LEARNING1.getValue() || (paper == PaperEnum.LEARNING2.getValue())) {
			if (row.getPhysicalNumberOfCells() == Const.SUB2_LENGTH) {
				return parseToLearningSubject(row, sentence);
			}
		}

		return null;
	}

	/**
	 * 转换为前测,后测,和追踪对象
	 * 
	 * @param row      行
	 * @param sentence 句子
	 * @return Subject
	 */
	public static Subject parseToBeforeSubject(Row row, String sentence) {
		Subject sub = new Subject();
		try {
			sub.setSentence(sentence);
			sub.setType(ExcelUtil.getAsInt(row, 1));
			sub.setQuestion(ExcelUtil.getAsStr(row, 2));
			sub.setAnswer(ExcelUtil.getAsStr(row, 3));
			sub.setOrigin(null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return sub;
	}

	/**
	 * 转换为前测,后测,和追踪对象
	 * 
	 * @param row      行
	 * @param sentence 句子
	 * @return Subject
	 */
	public static Subject parseToLearningSubject(Row row, String sentence) {
		Subject sub = new Subject();
		try {
			sub.setSentence(sentence);
			sub.setType(ExcelUtil.getAsInt(row, 1));
			sub.setQuestion(ExcelUtil.getAsStr(row, 2));
			sub.setAnswer(ExcelUtil.getAsStr(row, 3));
			sub.setOrigin(getAsStr(row, 4));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return sub;
	}

	/**
	 * 获取值
	 * 
	 * @param row    行
	 * @param column 列
	 * @return Integer
	 */
	public static Integer getAsInt(Row row, int column) {
		Number value = (Number) getValue(row.getCell(column));
		return value.intValue();
	}

	/**
	 * 获取值
	 * 
	 * @param row    行
	 * @param column 列
	 * @return String
	 */
	public static String getAsStr(Row row, int column) {
		Object value = getValue(row.getCell(column));
		return String.valueOf(value);
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell 单元格
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
	 * @param excelName excel名称
	 * 
	 * @param list      导出的数据
	 * 
	 * @return File
	 */
	public static File buildScoreResultExcel(String excelName, List<Score> list) {
		String[] titles = { "姓名", "学号", "开始学习英语年龄", "年龄", "四级分数", "六级分数", "专业", "句子类型", "问题回答正确率" };

		File file = new File(excelName + ".xlsx");
		try {
			// 创建工作簿
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("成绩");
			XSSFRow row = sheet.createRow(0);

			// 计算准确率
			double precisionRate = computePrecisionRate(list);

			// 第一行:头部信息
			for (int index = 0, len = titles.length; index < len; index++) {
				XSSFCell cell = row.createCell(index);
				cell.setCellValue(titles[index]);
			}

			if (null != list && list.size() > 0) {
				for (int index = 0, size = list.size(); index < size; index++) {
					row = sheet.createRow(index + 1);
					Score score = list.get(index);
					ExcelUtil.parseScoreToRow(row, score, precisionRate);
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
	 * 计算准确率
	 * 
	 * @param list 回答问题集合
	 * @return double
	 */ 
	private static double computePrecisionRate(List<Score> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}

		int rightAnwser = 0;
		int size = list.size();
		for (int index = 0; index < size; index++) {
			Score score = list.get(index);
			if (score.getCorrect() == 1) {
				rightAnwser++;
			}
		}
		return (1.0 * rightAnwser) / (1.0 * size);
	}

	/**
	 * 将成绩对象转换成excel的行数据
	 * 
	 * @param row           行
	 * @param score         成绩对象
	 * @param pricisionRate 准确率
	 */
	private static void parseScoreToRow(XSSFRow row, Score score, double pricisionRate) {
		try {

			Customer customer = score.getCustomer();
			int j = 0;
			// 1. 学生名称
			XSSFCell cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getName()));

			// 2. 学号
			cell = row.createCell(j++);
			cell.setCellValue(customer.getCode());

			// 3. 学习英语的年限
			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getEngAge()));

			// 4. 年龄
			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getAge()));

			// 5. 四级成绩
			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getCet4()));

			// 6. 六级成绩
			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getCet6()));

			// 7. 专业
			cell = row.createCell(j++);
			cell.setCellValue(asStr(customer.getMajor()));

			// 8. 试题类型
			cell = row.createCell(j++);
			cell.setCellValue(asStr(score.getSubType()));

			// 9. 回答准确度
			cell = row.createCell(j++);
			cell.setCellValue(pricisionRate);

			// 10. 每一个词的阅读时间
			String stopwatch = score.getStopwatch();
			if (null != stopwatch) {
				String[] arr = stopwatch.split(Const.EACH_SPLIT);
				for (String each : arr) {
					String[] values = each.split(Const.BETWEEN_SPLIT);
					String key = values[0];
					String time = values[1];
					cell = row.createCell(j++);
					cell.setCellValue(String.valueOf(key + ":" + time));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 获取值
	 * 
	 * @param obj 对象
	 * @return String
	 */
	private static String asStr(Object obj) {
		if (null == obj) {
			return "";
		}
		return String.valueOf(obj);
	}

}
