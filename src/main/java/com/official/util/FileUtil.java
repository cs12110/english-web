package com.official.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件处理辅助类
 * <p>
 * <p>
 * detailed comment
 *
 * @author huanghuapeng 2017年11月6日
 * @see
 * @since 1.0
 */
public class FileUtil {

	private FileUtil() {

	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 * @param filePath
	 *            文件绝对路径(包含文件名称)
	 */
	public static void download(HttpServletResponse response, String filePath) {
		if (StrUtil.isEmpty(filePath)) {
			return;
		}

		File file = new File(filePath);
		if (file.exists() && file.isFile()) {
			try {
				String temp = new String(file.getName().getBytes("gb2312"), "iso8859-1");
				response.setContentType("application/octet-stream;charset=utf-8");
				response.setHeader("Content-Disposition", "attachment;filename=" + temp);
				byte[] bits = new byte[1024];
				ServletOutputStream outputStream = response.getOutputStream();

				FileInputStream fin = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fin);

				int len = 0;
				while (-1 != (len = bis.read(bits))) {
					outputStream.write(bits, 0, len);
				}

				outputStream.flush();
				outputStream.close();

				bis.close();
				fin.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 上传文件,不需要修改上传文件名称
	 *
	 * @param file
	 *            {@link MultipartFile}
	 * @param saveFileDir
	 *            保存文件路径
	 * @return 返回保存文件的全部路径, 包括名称
	 */
	public static String uploadFile(MultipartFile file, String saveFileDir) {

		if (null == file || StrUtil.isEmpty(saveFileDir)) {
			throw new IllegalArgumentException("Error of File or save directory");
		}

		return uploadFile(file, saveFileDir, file.getOriginalFilename());
	}

	/**
	 * 上传文件
	 *
	 * @param file
	 *            文件对象
	 * @param saveFileDir
	 *            文件保存路径
	 * @param saveFileName
	 *            文件名称
	 * @return String
	 */
	public static String uploadFile(MultipartFile file, String saveFileDir, String saveFileName) {

		if (null == file || StrUtil.isEmpty(saveFileDir)) {
			throw new IllegalArgumentException("Error of File or save directory");
		}

		try {
			String wholePath = buileSaveName(saveFileDir, saveFileName);
			InputStream inputStream = file.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			OutputStream out = new FileOutputStream(new File(wholePath));
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

			int len = 0;
			byte[] b = new byte[1024 * 10];
			while (-1 != (len = inputStream.read(b))) {
				bufferedOutputStream.write(b, 0, len);
			}

			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			out.close();

			bufferedInputStream.close();
			inputStream.close();

			return wholePath;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 获取文件保存路径
	 *
	 * @param saveDir
	 *            保存文件夹路径
	 * @param saveFileName
	 *            保存文件名称
	 * @return String
	 */
	private static String buileSaveName(String saveDir, String saveFileName) {
		StringBuilder builder = new StringBuilder();
		builder.append(saveDir);
		builder.append(saveFileName);

		return builder.toString();
	}

	/**
	 * 获取文件保存名称
	 *
	 * @param file
	 *            {@link MultipartFile}
	 * @param saveName
	 *            保存名称(不带有后缀名)
	 * @return String
	 */
	public static String fixSaveName(MultipartFile file, String saveName) {
		String originFileName = file.getOriginalFilename();
		int dotIndex = originFileName.lastIndexOf(".");
		String suffix = originFileName.substring(dotIndex + 1);
		return saveName + suffix;
	}

	/**
	 * 往服务器写入内容
	 *
	 * @param path
	 *            写入路径(包括文件名称)
	 * @param byteArr
	 *            写入byte数组
	 */
	public static void write(String path, byte[] byteArr) {
		try {
			File file = new File(path);
			FileOutputStream out = new FileOutputStream(file);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

			bufferedOutputStream.write(byteArr);
			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取文件内容
	 *
	 * @param path
	 *            文件路径(包含文件名称)
	 * @return String
	 */
	public static String read(String path) {
		File file = new File(path);
		if (!file.exists() || !file.isFile()) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		try {
			FileInputStream inputStream = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

			int len = 0;
			byte[] bites = new byte[1024 * 10];
			while (-1 != (len = bufferedInputStream.read(bites))) {
				builder.append(new String(bites, 0, len));
			}

			bufferedInputStream.close();
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
