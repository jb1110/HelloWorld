package com.yedam.inheritance;

/*
 * 부모클래스: Animal(추상)
 */
public class Bird extends Animal {

	public void sound() {
		// 부모클래스의 sound라는 메소드를 반드시 재정의 해줘야함.
		System.out.println("짹짹");
	}

}
