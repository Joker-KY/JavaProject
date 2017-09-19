package com.jason.fileinputtest;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author jason
 * @since 2017-09-15
 * @version v1.0
 */
public class FileInputStreamTest {
	public static void readFile(File file) {

		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		if (file.isFile()) {
			try {
				// 读取文件
				fileInputStream = new FileInputStream(file);
				// 将输入流放入缓存输入流
				bufferedInputStream = new BufferedInputStream(fileInputStream);

				// int length = bufferedInputStream.read();
				// 输入流开始读取的位置
				int length = 0;
				System.out.println("length: " + length);
				// 设置一个存放数据的容器
				byte[] fileContent = new byte[1024];
				// System.out.println(length = bufferedInputStream.read(fileContent));

				while ((length = bufferedInputStream.read(fileContent)) != -1) {
					// 如果有数据将数据写入到字节数组输出流里
					byteArrayOutputStream.write(fileContent, 0, length);
				}
				// 将数据存放在字节数组里
				byte[] buffer = byteArrayOutputStream.toByteArray();
				// 打印字节数组里的内容
				System.out.println("fileContent: " + new String(buffer, "utf-8"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// 关闭流
					byteArrayOutputStream.close();
					bufferedInputStream.close();
					fileInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
