package day34;

import java.util.Random;
import java.util.Scanner;

class math extends Thread{
	Random ran = new Random();
	Scanner sc = new Scanner(System.in);
	private char[] aa = {'+','-','*','/'};
	int rat = 0; int count=0;
	
	
	@Override
	public void run() {
		int num=0; int num1=0;
		char ch =' '; int ret =0; 
		while(true) {
			num=ran.nextInt(10)+1;
			num1=ran.nextInt(10)+1;
			ch=aa[ran.nextInt(4)];
			switch (ch) {
		case '+':
			ret=num+num1;
			break;
		case '-':
			ret=num-num1;
			break;
		case '*':
			ret=num*num1;
			break;
		case '/':
			ret=num/num1;
			break;
		}
			System.out.printf("%2d %2c %2d=?\n", num,ch,num1);
			rat=Integer.parseInt(sc.nextLine());
			if(ret == rat) {
				System.out.println("정답입니다."); count++;
			}else System.out.println("오답입니다.");
			
	} 
//	public int a() {
//		
//	}
}
	
}

class time extends Thread{
	math ab = new math();


	int time=10;
	int count =0;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void run() {
	ab.setDaemon(true);
	ab.start();
	
	while(true) {
		System.out.println(time+"초");
		try {
			Thread.sleep(1000);
			time--;
		}catch(InterruptedException e) {
			
		}
		if(time ==0) {
			System.out.println("게임종료");
			System.out.println(ab.count+"개 정답");
			System.exit(0);
			
			
			}
		}
	
	}
}

public class Ex06 {
	public static void main(String[] args) {
		time ab = new time();
		ab.start();
		
	}
}