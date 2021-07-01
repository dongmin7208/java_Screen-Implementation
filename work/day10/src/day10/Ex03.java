package day10;

class MyThread05 extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println("☆☆☆☆☆☆☆☆☆☆☆");
		}
	}
}
class MyThread06 implements Runnable{
	@Override
	public void run() {
		while(true) {
			System.out.println("★★★★★★★★★★★★");
		}
	}
}

public class Ex03 {
	public static void main(String[] args) {
		System.out.println("main시작");
		MyThread05 th1 = 
				new MyThread05();
		MyThread06 th2 = new MyThread06();
		Thread th = new Thread(th2);
		//th1.setDaemon(true);
		//th.setDaemon(true);
		th1.start();//새로운 스레드로 run()시작
		th.start();
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%2d ", i);
			if(i%10 == 0) {
				System.out.println();
			}
		}
		System.out.println("main끝");

	}
}
