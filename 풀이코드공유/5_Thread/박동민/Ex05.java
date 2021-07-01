package day34;

import java.util.Scanner;
class MyThread00 extends Thread{
	int time = 10;
	@Override
	public void run() {
	while(true) {
		
		try {
			Thread.sleep(1000);
			time--;
		}catch(InterruptedException e) {
			
		}
		if(time == 0) {
			System.out.println("게임종료");
			System.exit(0);
		}
	}
		
	}
}

public class Ex05 {
	public static void main(String[] args) {
		System.out.println("main시작");
		MyThread00 th1 = 
				new MyThread00();
		Thread th00 = new Thread(th1);
		//th1.setDaemon(true);
		//th.setDaemon(true);
		th00.start();//새로운 스레드로 run()시작
		Scanner sc = new Scanner(System.in);
		String a=" ";
		while(th1.time!=0) {
			System.out.print("입력:");
			a=sc.nextLine();
			System.out.println("남은시간 : "+th1.time + "초");
			System.out.println("입력 받은 값 : " + a);
		}
	}


	
}
