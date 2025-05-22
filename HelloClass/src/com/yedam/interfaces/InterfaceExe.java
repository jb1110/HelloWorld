package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10;
		RemoteControl rc = Television();
		rc.turnON();
		rc.turnOff();
	}
}
