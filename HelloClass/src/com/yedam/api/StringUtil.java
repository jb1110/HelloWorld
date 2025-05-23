package com.yedam.api;

public class StringUtil {
	public static void main(String[] args) {
	}

	public static String getGender(String ssn) {
		ssn = ssn.replace("-", "").replace(" ", "");
		{
			if (ssn.length() != 13)
				return "잘못된 주민등록번호";
		}
		char gen = ssn.charAt(6);
		switch (gen) {
		case '1':
		case '3':
			return "남성";
		case '2':
		case '4':
			return "여성";
		default:
			return "사람아님";
		}
	}

	static String getFileName1(String file) {
		int pos = 0;
		String fileName = "";
		while (true) {
			int idx = file.indexOf("/", pos);
			if (idx == -1) {
				fileName = file.substring(pos);
				break;
			}
			pos = idx + 1;
		}
		return fileName;

	}

}