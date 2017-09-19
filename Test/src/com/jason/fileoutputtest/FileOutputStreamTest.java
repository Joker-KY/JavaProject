package com.jason.fileoutputtest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jason
 * @since 2017-09-15
 * @version v1.0
 */
public class FileOutputStreamTest {
	public static void writeToFile(File file, String fileContent) {

		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;

		// 判断文件是否存在
		if (!file.isFile()) {
			try {
				// 创建文件
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 打印文件名
		System.out.println("fileName: " + file.getName());

		try {
			// 将文件放入输出流中
			fileOutputStream = new FileOutputStream(file);
			// 将文件输出流放入缓存输出流中
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			// 写入数据
			bufferedOutputStream.write(fileContent.getBytes("utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 判断缓存输出流中是否存在数据
				if (bufferedOutputStream != null) {
					bufferedOutputStream.flush(); // 刷新流
					bufferedOutputStream.close(); // 关闭流
				}
				fileOutputStream.close();// 关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
