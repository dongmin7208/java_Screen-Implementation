package day09;

import java.util.Scanner;
/*
 * 예외처리:예외 발생 시 어떻게 동작할 것인지 처리를 결정
 * try{} : 예외가 발생되는 코드 블록 지정
 * catch(e){}: try{}블록에서 던져지는(발생되는) 예외 객체를 잡아서 처리할 내용을 작성해주는 블록
 * 
 */
public class Ex02 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("첫 번째 수:");
		int n1 = in.nextInt();
		System.out.print("두 번째 수:");
		int n2 = in.nextInt();
		int ret = 0;
		try{
			ret = n1 / n2;
			System.out.println("예외없음");
		}catch(ArithmeticException e) {
			System.out.println("예외발생");
		}
		System.out.println("결과:" + ret);

	}
}
