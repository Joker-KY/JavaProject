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

		// �ж��ļ��Ƿ����
		if (!file.isFile()) {
			try {
				// �����ļ�
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ��ӡ�ļ���
		System.out.println("fileName: " + file.getName());

		try {
			// ���ļ������������
			fileOutputStream = new FileOutputStream(file);
			// ���ļ���������뻺���������
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			// д������
			bufferedOutputStream.write(fileContent.getBytes("utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �жϻ�����������Ƿ��������
				if (bufferedOutputStream != null) {
					bufferedOutputStream.flush(); // ˢ����
					bufferedOutputStream.close(); // �ر���
				}
				fileOutputStream.close();// �ر���
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
