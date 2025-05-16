package com.yedam.ref;

public class ArrayExe1 {
	public static void main(String[] args) {
		// math.random 활용하여 10 ~ 100 사이의 값을 생성.
		// 학생 10명의 점수를 생성하여 평균을 구하고 최고점수 구하
		// 변수명은 scoreAry로.
		int scoreAry [] = new int [10];
		
		int sum = 0;
		int	max = 0;
		
		for (int i = 0; i < scoreAry.length; i++) {
			scoreAry [i] = (int)(Math.random() * 91) + 10; 
			sum += scoreAry[i];
			if (scoreAry[i] > max) {
				max = scoreAry[i];
			}
		}
		double averge = (double) sum / scoreAry.length;
		System.out.println("10명 점수목록");
		for (int score : scoreAry) {
			System.out.print(score + " ");
		}
		System.out.println("\n평균점수:" + averge);
		System.out.println("최고점수:" + max);
	}
}