package day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * ����ó��:���� �߻� �� ��� ������ ������ ó���� ����
 * try{} : ���ܰ� �߻��Ǵ� �ڵ� ��� ����
 * catch(e){}: try{}��Ͽ��� ��������(�߻��Ǵ�) ���� ��ü�� ��Ƽ�(����) ó���� ������ �ۼ����ִ� ���
 * �ڹٿ��� ��� ���ܰ�ü�� ExceptionŬ������ ��ӹ޴´�.
 * catch�� �������� ���ǵǾ�� �ϴ� ��� ����Ŭ������ ������ ���ܰ�ü ��������
 * 
 * finally{} : ���� �߻� ���ο� ������� ������ ������ �ڵ� ���
 * 		 - try{}finally{}
 * 		 - try{}catch(){}finally{}
 * 
 * throw : ���� ��ü�� ������ ����
 * 
 * ����� ���� ����
 * ������ ���ۿ� ���ؼ� �����ڰ� ���� ���� Ŭ������ ���� �Ͽ� ����� �� �ִ�.
 * 
 * throws : �ش� �Լ��� � ���ܸ� ���� �� �ִٶ�� ���� ����
 * 			���ܸ� �߻���ų �� �ִ�(throw) �Լ��� ȣ���ϴ� ������ ���ܸ� ���� 
 * 
 * Exception : ������ ������ ����ó�� ���θ� Ȯ��(������)
 * RuntimeException : ���� �߿� �߻��Ǵ� ����(������ �� ����ó�� ���� Ȯ���� ���� ����)
 */

class MyOverValueException3 extends RuntimeException{
	public MyOverValueException3(String m) {
		super(m);
	}
}

public class Ex11 {
	static Scanner in = new Scanner(System.in);
	static int input() throws MyOverValueException3{
		int ret = in.nextInt();
		if(ret > 10) {
			throw new MyOverValueException3("10�̻� �Է� ����");
		}
		return ret;
	}
	static int div(int n1, int n2) throws ArithmeticException{
		int ret = n1 / n2;
		return ret;
	}
	static int stringToInt() {
		int ret = Integer.parseInt(in.nextLine());
		return ret;
	}
	public static void main(String[] args) {
		int n1 = 0, n2 = 0, ret = 0;
		n1 = input(); //���� �߻���? ���� �غ��� ��
		div(10, 20);
		try{
			System.out.print("ù ��° ��:");
			n1 = input();
			System.out.print("�� ��° ��:");
			n2 = input();
			ret = div(n1, n2);
			/*
			 * try��Ͽ��� �߻��Ǵ� ���� ������ ���� ���
			 * ������ ����(�θ�)ó���� �ڷ� �ۼ��Ѵ�.
			 * 
			 */
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� ����!");
		}catch(InputMismatchException e) {
			System.out.println("�Է� ���� ����!");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("������ ������!");
		}
		System.out.println("���:" + ret);
	}
}
