package com.jason.qrcodeonline;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jason.createqrcode.QRCode;

public class QRCode_Online extends HttpServlet {

	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private static String CHARSET = "utf-8";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置文件编码格式
		resp.setCharacterEncoding(CHARSET);
		// int codeWidth = req.get
//		BufferedImage bufferedImage = QRCode.codeCreate(content, codeWidth, codeHeight, CHARSET);
	}

}
