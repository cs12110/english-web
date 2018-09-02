package com.test.dic;

/**
 * 列属性
 * 
 * @author root
 *
 */
public enum ColumnMetaEnum {

	/**
	 * 数据库名称
	 */
	TABLE_CAT("TABLE_CAT"),

	/**
	 *  
	 */
	TABLE_SCHEM("TABLE_SCHEM"),

	/**
	 * 表 名称
	 */
	TABLE_NAME("TABLE_NAME"),

	/**
	 * 列名称
	 */
	COLUMN_NAME("COLUMN_NAME"),

	/**
	 * 数据类型
	 */
	DATA_TYPE("DATA_TYPE"),

	/**
	 * 类型名称
	 */
	TYPE_NAME("TYPE_NAME"),

	/**
	 * 列
	 */
	COLUMN_SIZE("COLUMN_SIZE"),

	/**
	 * 缓冲区
	 */
	BUFFER_LENGTH("BUFFER_LENGTH"),

	/**
	 * 
	 */
	DECIMAL_DIGITS("DECIMAL_DIGITS"),

	/**
	 * 
	 */
	NUM_PREC_RADIX("NUM_PREC_RADIX"),

	/**
	 * 是否为空
	 */
	NULLABLE("NULLABLE"),

	/**
	 * 备注
	 */
	REMARKS("REMARKS"),

	/**
	 * 
	 */
	COLUMN_DEF("COLUMN_DEF"),

	/**
	 * 
	 */
	SQL_DATA_TYPE("SQL_DATA_TYPE"),

	/**
	 * 
	 */
	SQL_DATETIME_SUB("SQL_DATETIME_SUB"),

	/**
	 * 
	 */
	CHAR_OCTET_LENGTH("CHAR_OCTET_LENGTH"),

	/**
	 * 列号
	 */
	ORDINAL_POSITION("ORDINAL_POSITION"),

	/**
	 * 是否可以为空
	 */
	IS_NULLABLE("IS_NULLABLE"),

	/**
	 * 
	 */
	SCOPE_CATALOG("SCOPE_CATALOG"),

	/**
	 * 
	 */
	SCOPE_SCHEMA("SCOPE_SCHEMA"),

	/**
	 * 
	 */
	SCOPE_TABLE("SCOPE_TABLE"),

	/**
	 * 
	 */
	SOURCE_DATA_TYPE("SOURCE_DATA_TYPE"),

	/**
	 * 自动增长
	 */
	IS_AUTOINCREMENT("IS_AUTOINCREMENT"),

	/**
	 * 主键
	 */
	IS_GENERATEDCOLUMN("IS_GENERATEDCOLUMN");

	private final String mateName;

	private ColumnMetaEnum(String mateName) {
		this.mateName = mateName;
	}

	public String getMateName() {
		return mateName;
	}

}
