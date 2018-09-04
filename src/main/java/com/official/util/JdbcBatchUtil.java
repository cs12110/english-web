package com.official.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.official.entity.Subject;

/**
 * Jdbc批处理
 * 
 * @author root
 *
 */
public class JdbcBatchUtil {

	private static Logger logger = LoggerFactory.getLogger(JdbcBatchUtil.class);

	private DataSource dataSource;
	/**
	 * 每次处理条数
	 */
	private int batchNum = 100;

	/**
	 * 构造方法
	 * 
	 * @param dataSource 数据源
	 */
	public JdbcBatchUtil(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	/**
	 * 构造方法
	 * 
	 * @param dataSource 数据源
	 * @param batchNum   批处理条数
	 */
	public JdbcBatchUtil(DataSource dataSource, int batchNum) {
		super();
		this.dataSource = dataSource;
		if (batchNum > 0) {
			this.batchNum = batchNum;
		}
	}

	/**
	 * 批量现在subject
	 * 
	 * @param list {@link Subject} 集合
	 * @throws SQLException
	 */
	public void batchAdd(List<Subject> list) throws SQLException {
		long start = System.currentTimeMillis();
		Connection conn = dataSource.getConnection();
		conn.setAutoCommit(false);
		try {
			String sql = "INSERT INTO `subject_t` (`sentence`, `type`, `question`, `answer`, `paper`,origin)"
					+ " VALUES ( ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstm = conn.prepareStatement(sql);
			for (int i = 0, size = list.size(); i < size; i++) {
				Subject s = list.get(i);
				pstm.setString(1, s.getSentence());
				pstm.setInt(2, s.getType());
				pstm.setString(3, s.getQuestion());
				pstm.setString(4, s.getAnswer());
				pstm.setInt(5, s.getPaper());
				pstm.setString(6, s.getOrigin());
				pstm.addBatch();

				if (i != 0 && i % batchNum == 0) {
					pstm.executeBatch();
					conn.commit();
					pstm.clearBatch();
				}
			}

			pstm.executeBatch();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			conn.setAutoCommit(true);
		}
		long end = System.currentTimeMillis();
		logger.info("Process {} ,spend :{}", list.size(), (end - start));
	}

}
