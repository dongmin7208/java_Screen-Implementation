package day10;

class MyThread03 extends Thread{
	@Override
	public void run() {
		System.out.println("A����");
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			for(int j = 0; j < 1000000000; j++);
			System.out.print(ch);
		}
		System.out.println("A��");
	}
}
class MyThread04 implements Runnable{
	@Override
	public void run() {
		System.out.println("a����");
		for(char ch = 'a'; ch <= 'z'; ch++) {
			for(int j = 0; j < 1000000000; j++);
			System.out.print(ch);
		}
		System.out.println("a��");
	}
}

public class Ex02 {
	public static void main(String[] args) {
		System.out.println("main����");
		MyThread03 th1 = 
				new MyThread03();
		MyThread04 th2 = new MyThread04();
		Thread th = new Thread(th2);
		th1.setDaemon(true);
		th1.setDaemon(true);
		th1.start();//���ο� ������� run()����
		th.start();
		
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%2d ", i);
			if(i%10 == 0) {
				System.out.println();
			}
		}
		System.out.println("main��");

	}
}
