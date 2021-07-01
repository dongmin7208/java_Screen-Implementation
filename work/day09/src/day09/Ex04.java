package day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 예외처리:예외 발생 시 어떻게 동작할 것인지 처리를 결정
 * try{} : 예외가 발생되는 코드 블록 지정
 * catch(e){}: try{}블록에서 던져지는(발생되는) 예외 객체를 잡아서(참조) 처리할 내용을 작성해주는 블록
 * 
 */
public class Ex04 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = 0;
		System.out.print("첫 번째 수:");
		try {
			n1 = in.nextInt();
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		int n2 = 0;
		System.out.print("두 번째 수:");
		try{
			n2 = in.nextInt();
		}catch(InputMismatchException e) {
			System.out.println("예외!");
		}
		int ret = 0;
		if(n2 != 0) {
			ret = n1 / n2;
		}else {
			System.out.println("예외발생");
		}
		System.out.println("결과:" + ret);

	}
}
