package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

// writer
public class StreamExe2 {
	public static void main(String[] args) {

		try {
			Scanner scanner = new Scanner(new File("c:/temp/writer.txt")); // 파일명 추가 (.txt 등)
			try {
				while (scanner.hasNextLine()) { // 무한루프 → 파일 끝까지 읽도록 수정
					String data = scanner.nextLine();
					String[] strAry = data.split(" ");
					System.out.println(strAry[0] + "," + strAry[1]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				scanner.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // 외부 try-catch 끝

	}

	//////////////////////////////////////////////////////////////////////
	// char기반의 입력스트림
	public static void read() {
		try {
			Reader reader = new FileReader("c:/temp/writer.txt");
			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.print((char) data);
			}
			reader.close();
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/////////////////////////////////////////////////////////////////////////////////
	// char기반의 출력스트립.
	public static void write() {

		try {
			Writer wr = new FileWriter("c:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.write('D');
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
