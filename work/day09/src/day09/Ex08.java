package day09;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 예외처리:예외 발생 시 어떻게 동작할 것인지 처리를 결정
 * try{} : 예외가 발생되는 코드 블록 지정
 * catch(e){}: try{}블록에서 던져지는(발생되는) 예외 객체를 잡아서(참조) 처리할 내용을 작성해주는 블록
 * 자바에서 모든 예외객체는 Exception클래스를 상속받는다.
 * catch가 연속으로 정의되어야 하는 경우 상위클래스의 참조로 예외객체 참조가능
 * 
 * finally{} : 예외 발생 여부와 관계없이 무조건 실행할 코드 블록
 * 		 - try{}finally{}
 * 		 - try{}catch(){}finally{}
 * 
 * throw : 예외 객체를 던지는 구문
 */
public class Ex08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = 0, n2 = 0, ret = 0;
		try{
			
			System.out.print("첫 번째 수:");
			n1 = in.nextInt();
			if(n1 > 10) {
				//throw new NumberFormatException();
				throw new NumberFormatException("10이상 입력 예외");
			}
			System.out.print("두 번째 수:");
			n2 = in.nextInt();
			ret = n1 / n2;
			/*
			 * try블록에서 발생되는 예외 종류가 많을 경우
			 * 범위가 넓은(부모)처리를 뒤로 작성한다.
			 * 
			 */
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음!");
		}catch(InputMismatchException e) {
			System.out.println("입력 형식 오류!");
		}catch(Exception e) {
			System.out.println("10이상 예외");
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행블록!");
		}
		System.out.println("결과:" + ret);

	}
}
