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
 */
public class Ex08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = 0, n2 = 0, ret = 0;
		try{
			
			System.out.print("ù ��° ��:");
			n1 = in.nextInt();
			if(n1 > 10) {
				//throw new NumberFormatException();
				throw new NumberFormatException("10�̻� �Է� ����");
			}
			System.out.print("�� ��° ��:");
			n2 = in.nextInt();
			ret = n1 / n2;
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
			System.out.println("10�̻� ����");
			e.printStackTrace();
		}finally {
			System.out.println("������ ������!");
		}
		System.out.println("���:" + ret);

	}
}
