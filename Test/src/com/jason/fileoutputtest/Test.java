package com.jason.fileoutputtest;

import java.io.File;
import java.util.Scanner;
import com.jason.fileinputtest.*;

/**
 * @author jason
 * @since 2017-09-15
 * @version v1.0
 */
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		File file = new File("c:/Users/jason/Desktop/InputStream/file.txt");
		System.out.println("ÇëÊäÈë×Ö·û´®£º");
		FileOutputStreamTest.writeToFile(file, input.next());
		FileInputStreamTest.readFile(file);
	}
}
