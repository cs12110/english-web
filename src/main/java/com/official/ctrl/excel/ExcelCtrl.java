package com.official.ctrl.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.official.entity.Subject;
import com.official.entity.reply.Reply;
import com.official.enums.ReplyEnum;
import com.official.service.subject.SubjectService;

/**
 * 处理文件上传
 *
 * <p>
 * 
 * @author huanghuapeng 2018年8月15日
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/excel")
public class ExcelCtrl {

	private static Logger logger = LoggerFactory.getLogger(ExcelCtrl.class);

	@Autowired
	private SubjectService subjectService;

	/**
	 * 跳转到下载页面
	 *
	 * @param map
	 *            传递参数Map
	 * @param takeFileUrl
	 *            处理上传文件的url
	 * @return Html
	 */
	@RequestMapping("/toUpload")
	public String toUploadHtml(ModelMap map, String takeFileUrl) {
		return "admin/upload";
	}

	@RequestMapping("/upload")
	@ResponseBody
	public String uploadfile(MultipartFile file) throws IOException {

		Reply reply = new Reply();
		reply.setStatus(ReplyEnum.SUCCESS.getValue());
		try {

			String name = file.getName();

			if (!name.endsWith("")) {
				reply.setStatus(ReplyEnum.FAILURE.getValue());
				reply.setMessage("文件必须为excel(.xlsx)文件");
				return reply.toString();
			}

			Map<String, Integer> result = processExcel(file.getInputStream());
			reply.setData(result);

			logger.info("Upload file {} is done, {}", name, result.toString());
		} catch (Exception e) {
			e.printStackTrace();
			reply.setStatus(ReplyEnum.FAILURE.getValue());
		}

		return reply.toString();
	}

	/**
	 * 处理excel文件
	 * 
	 * @param stream
	 *            文件流
	 * @return Map
	 */
	private Map<String, Integer> processExcel(InputStream stream) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		try {
			Workbook workBook = WorkbookFactory.create(stream);
			Sheet sheet = workBook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			int success = 0;
			int failure = 0;
			for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				Subject subject = parseToSubject(row);
				// 执行数据库增加操作
				if (null != subject) {
					try {
						subjectService.insert(subject);
						success++;
					} catch (Exception e) {
						logger.error("Have an error on:{}", subject.toString());
						e.printStackTrace();
						failure++;
					}
				}
			}
			map.put("success", success);
			map.put("failure", failure);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
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
			return cell.getRichStringCellValue().getString();
		}
		return cell.getStringCellValue();
	}
}
