package day09;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("첫 번째 수:");
		int n1 = in.nextInt();
		System.out.print("두 번째 수:");
		int n2 = in.nextInt();
		int ret = n1 / n2;
		System.out.println("결과:" + ret);

	}
}
