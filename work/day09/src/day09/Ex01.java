package day09;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("ù ��° ��:");
		int n1 = in.nextInt();
		System.out.print("�� ��° ��:");
		int n2 = in.nextInt();
		int ret = n1 / n2;
		System.out.println("���:" + ret);

	}
}
