package com.test.dic;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数据库信息工具类
 * 
 * @author root
 *
 */
public class DbInfoUtil {

	/**
	 * 获取数据库里面所有的表
	 * 
	 * @param conn   连接
	 * @param dbName 数据库名称
	 * @return List
	 */
	public static List<String> getTableList(Connection conn, String dbName) {
		List<String> tableList = new ArrayList<>();
		try {
			DatabaseMetaData dbMetaData = conn.getMetaData();
			ResultSet columns = dbMetaData.getColumns(dbName, null, null, null);
			Set<String> tableSet = new HashSet<String>();
			while (columns.next()) {
				tableSet.add(getMetaVal(columns, ColumnMetaEnum.TABLE_NAME));
			}
			tableList.addAll(tableSet);
			JdbcUtil.fuckoff(null, null, columns);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tableList;
	}

	/**
	 * 获取表里面所有的列的属性
	 * 
	 * @param conn      连接
	 * @param dbName    数据库名称
	 * @param tableName 表名称
	 * @return List
	 */
	public static List<FieldBean> getFieldFromTable(Connection conn, String dbName, String tableName) {
		List<FieldBean> fieldList = new ArrayList<FieldBean>();
		try {
			DatabaseMetaData dbMetaData = conn.getMetaData();
			ResultSet columns = dbMetaData.getColumns(dbName, "%", tableName, "%");
			String key = getPrimaryKey(dbMetaData, dbName, tableName);
			while (columns.next()) {
				FieldBean field = new FieldBean();
				field.setAutoIncre(columns.getString(ColumnMetaEnum.IS_AUTOINCREMENT.getMateName()));
				field.setName(getMetaVal(columns, ColumnMetaEnum.COLUMN_NAME));
				field.setType(getMetaVal(columns, ColumnMetaEnum.TYPE_NAME));
				field.setDesc(getMetaVal(columns, ColumnMetaEnum.REMARKS));
				field.setNullable(getMetaVal(columns, ColumnMetaEnum.IS_NULLABLE));
				field.setLength(getMetaVal(columns, ColumnMetaEnum.COLUMN_SIZE));
				field.setDefValue(getMetaVal(columns, ColumnMetaEnum.COLUMN_DEF));
				if (field.getName().equals(key)) {
					field.setIsKey("YES");
				}
				fieldList.add(field);
			}
			JdbcUtil.fuckoff(null, null, columns);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fieldList;
	}

	/**
	 * 获取数据库表的主键
	 * 
	 * @param dbMetaData 数据库元数据
	 * @param dbName     数据库名称
	 * @param tableName  表名称
	 * @return String
	 */
	private static String getPrimaryKey(DatabaseMetaData dbMetaData, String dbName, String tableName) {
		String key = "";
		try {
			ResultSet primaryKeys = dbMetaData.getPrimaryKeys(dbName, null, tableName);
			if (primaryKeys.next()) {
				key = getMetaVal(primaryKeys, ColumnMetaEnum.COLUMN_NAME);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return key;
	}

	/**
	 * 获取表里面的信息
	 * 
	 * @param result {@link ResultSet}
	 * @param meta   {@link ColumnMetaEnum}
	 * @return String
	 */
	private static String getMetaVal(ResultSet result, ColumnMetaEnum meta) {
		try {
			return result.getString(meta.getMateName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}