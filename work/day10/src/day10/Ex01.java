package day10;

class MyThread01 extends Thread{
	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
	}
}
class MyThread02 implements Runnable{
	@Override
	public void run() {
		for(char ch = 'a'; ch <= 'z'; ch++) {
			System.out.print(ch);
		}
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		MyThread01 th1 = 
				new MyThread01();
		th1.start();//새로운 스레드로 run()시작
		
		MyThread02 th2 = new MyThread02();
		Thread th = new Thread(th2);
		th.start();
		
		for(int i = 1; i <= 100; i++) {
			System.out.printf("%2d ", i);
			if(i%10 == 0) {
				System.out.println();
			}
		}
	}
}
