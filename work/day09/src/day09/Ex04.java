package day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * ����ó��:���� �߻� �� ��� ������ ������ ó���� ����
 * try{} : ���ܰ� �߻��Ǵ� �ڵ� ��� ����
 * catch(e){}: try{}��Ͽ��� ��������(�߻��Ǵ�) ���� ��ü�� ��Ƽ�(����) ó���� ������ �ۼ����ִ� ���
 * 
 */
public class Ex04 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = 0;
		System.out.print("ù ��° ��:");
		try {
			n1 = in.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		int n2 = 0;
		System.out.print("�� ��° ��:");
		try{
			n2 = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("����!");
		}
		int ret = 0;
		if(n2 != 0) {
			ret = n1 / n2;
		}else {
			System.out.println("���ܹ߻�");
		}
		System.out.println("���:" + ret);

	}
}
