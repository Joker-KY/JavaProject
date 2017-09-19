package com.jason.qrcodemaintest;

import com.jason.createqrcode.QRCode;

/**
 * @author jason
 * ������
 */
public class MainCodeTest {

	private static final String CHAR_CODESET = "UTF-8";

	public static void main(String[] args) {
		String content = "��˵��Ҫ��һ����ά�룡����";
		int codeWidth = 300;
		int codeHeight = 300;
		QRCode.codeCreate(content, codeWidth, codeHeight, CHAR_CODESET);

	}
}
