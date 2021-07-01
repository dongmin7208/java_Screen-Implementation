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
 * 
 * 사용자 정의 예외
 * 임의의 동작에 대해서 개발자가 직접 예외 클래스를 정의 하여 사용할 수 있다.
 * 
 * throws : 해당 함수가 어떤 예외를 던질 수 있다라는 것을 선언
 * 			예외를 발생시킬 수 있는(throw) 함수를 호출하는 곳으로 예외를 전가 
 * 
 * Exception : 컴파일 시점에 예외처리 여부를 확인(무조건)
 * RuntimeException : 실행 중에 발생되는 예외(컴파일 시 예외처리 여부 확인을 하지 않음)
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
			throw new MyOverValueException3("10이상 입력 예외");
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
		n1 = input(); //예외 발생함? 실행 해봐야 앎
		div(10, 20);
		try{
			System.out.print("첫 번째 수:");
			n1 = input();
			System.out.print("두 번째 수:");
			n2 = input();
			ret = div(n1, n2);
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
			e.printStackTrace();
		}finally {
			System.out.println("무조건 실행블록!");
		}
		System.out.println("결과:" + ret);
	}
}
