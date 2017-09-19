package com.jason.qrcodemaintest;

import com.jason.createqrcode.QRCode;

/**
 * @author jason
 * 测试类
 */
public class MainCodeTest {

	private static final String CHAR_CODESET = "UTF-8";

	public static void main(String[] args) {
		String content = "神说，要有一个二维码！！！";
		int codeWidth = 300;
		int codeHeight = 300;
		QRCode.codeCreate(content, codeWidth, codeHeight, CHAR_CODESET);

	}
}
