package com.jason.createqrcode;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
	private static String CHARSET = "UTF-8";
	private static String CODE_FORMAT = "png";

	/**
	 * ���ɶ�ά��
	 * 
	 * @param content
	 *            ��ά������
	 * @param codeWidth
	 *            ��ά����
	 * @param codeHeight
	 *            ��ά�볤��
	 * @param charSet
	 *            ��ά������ʽ
	 */
	public static void codeCreate(String content, int codeWidth, int codeHeight, String charSet) {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

		// �ݴ���
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// �����ʽ
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
		MultiFormatWriter codeMultiFormatWriter = new MultiFormatWriter();
		BitMatrix codeBitMatrix = null;
		try {
			codeBitMatrix = codeMultiFormatWriter.encode(content, BarcodeFormat.QR_CODE, codeWidth, codeHeight, hints);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Random random = new Random();
		//��ά����·��
		File codeFile = new File("C:/Users/jason/Desktop/QRCode/result/" + random.nextInt() + "qrcode." + CODE_FORMAT);

		try {
			// ��ά���ļ�ת��Ϊ��
			FileOutputStream codeFileOutputStream = new FileOutputStream(codeFile);
			BufferedOutputStream codeBufferedOutputStream = new BufferedOutputStream(codeFileOutputStream);
			// ��ά���Ծ������
			MatrixToImageWriter.writeToStream(codeBitMatrix, CODE_FORMAT, codeBufferedOutputStream);
			// ���벢���
			System.out.println(codeDecode(codeFile.getPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ά�����
	 * 
	 * @param filePath
	 *            �ļ����λ��
	 */
	public static String codeDecode(String filePath) {
		String codeContent = "";
		if (filePath.length() == 0 && "".equalsIgnoreCase(filePath)) {
			return "�ļ�·��Ϊ�գ�";
		}
		try {
			BufferedImage fileBufferedImage = ImageIO.read(new FileInputStream(filePath));
			// ���������
			LuminanceSource luminanceSource = new BufferedImageLuminanceSource(fileBufferedImage);
			Binarizer binarizer = new HybridBinarizer(luminanceSource);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
			Result result = new MultiFormatReader().decode(binaryBitmap, hints);
			codeContent = result.getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeContent;
	}
}
