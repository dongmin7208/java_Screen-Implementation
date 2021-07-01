package day09;

import java.util.Scanner;
/*
 * ����ó��:���� �߻� �� ��� ������ ������ ó���� ����
 * try{} : ���ܰ� �߻��Ǵ� �ڵ� ��� ����
 * catch(e){}: try{}��Ͽ��� ��������(�߻��Ǵ�) ���� ��ü�� ��Ƽ� ó���� ������ �ۼ����ִ� ���
 * 
 */
public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("ù ��° ��:");
		int n1 = in.nextInt();
		System.out.print("�� ��° ��:");
		int n2 = in.nextInt();
		int ret = 0;
		try{
			ret = n1 / n2;
			System.out.println("���ܾ���");
		}catch(ArithmeticException e) {
			System.out.println("���ܹ߻�");
		}
		System.out.println("���:" + ret);

	}
}
