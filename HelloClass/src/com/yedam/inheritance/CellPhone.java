package com.yedam.inheritance;
/*
 * 부모: CellPhone
 *   - 전원켜기, 전원끄기, 통화, 볼륨Up, 볼륨Down 통화
 *   - Model, Color
 * 자식: SmartPhone
 * 	 - 전원켜기, 전원끄기, 통화, 볼륨Up, 볼륨Down, TV 보기
 *   -
 */
public class CellPhone /*extends Object*/ {
	String model;
	String color;
	//생성자.
	public CellPhone() {}
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}





	public void powerOn() {
		System.out.println("전원을 켜기.");
	}
	public void powerOff() {
		System.out.println("전원을 끄기.");
	}
	void 통화하기() {
		System.out.println("통화하기.");
	}
	// toString() 오버라이딩
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
	
} // end of class
