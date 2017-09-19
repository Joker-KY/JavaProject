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
				// ��ȡ�ļ�
				fileInputStream = new FileInputStream(file);
				// �����������뻺��������
				bufferedInputStream = new BufferedInputStream(fileInputStream);

				// int length = bufferedInputStream.read();
				// ��������ʼ��ȡ��λ��
				int length = 0;
				System.out.println("length: " + length);
				// ����һ��������ݵ�����
				byte[] fileContent = new byte[1024];
				// System.out.println(length = bufferedInputStream.read(fileContent));

				while ((length = bufferedInputStream.read(fileContent)) != -1) {
					// ��������ݽ�����д�뵽�ֽ������������
					byteArrayOutputStream.write(fileContent, 0, length);
				}
				// �����ݴ�����ֽ�������
				byte[] buffer = byteArrayOutputStream.toByteArray();
				// ��ӡ�ֽ������������
				System.out.println("fileContent: " + new String(buffer, "utf-8"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					// �ر���
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
