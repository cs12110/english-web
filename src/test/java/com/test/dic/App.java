package com.test.dic;


import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 制造markdown文件
 * 
 * @author root
 *
 */
public class App {

	public static void main(String[] args) {
		String dbUrl = "jdbc:mysql://127.0.0.1";
		String dbUser = "root";
		String dbPassword = "";
		String dbName = "english_web";
		String mdPath = "d://数据字典.md";

		System.out.println("------ 开始 -------");
		execute(dbUrl, dbUser, dbPassword, dbName, mdPath);
		System.out.println("------ 结束 -------");
	}

	/**
	 * 创建md文件
	 * 
	 * @param url
	 *            数据库地址
	 * @param user
	 *            用户
	 * @param password
	 *            密码
	 * @param dbName
	 *            数据库名称
	 * @param mdPath
	 *            markdown文件保存路径
	 */
	private static void execute(String url, String user, String password, String dbName, String mdPath) {
		Connection conn = JdbcUtil.getMySqlConn(url, user, password);
		List<String> tableList = DbInfoUtil.getTableList(conn, dbName);
		Map<String, List<FieldBean>> infoMap = new HashMap<>();

		for (String tableName : tableList) {
			List<FieldBean> fieldList = DbInfoUtil.getFieldFromTable(conn, dbName, tableName);
			infoMap.put(tableName, fieldList);
		}
      
		JdbcUtil.fuckoff(conn, null, null);
		MarkdownUtil.buildMd(mdPath, infoMap);
	}
}
